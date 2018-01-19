package cn.pioneer.dcim.cmdb.sync.in;

import cn.pioneer.dcim.cmdb.common.util.ZZBeanUtils;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.orm.mapper.SysUserMapper;
import cn.pioneer.dcim.cmdb.orm.model.SysUser;
import cn.pioneer.dcim.cmdb.services.impl.PersonServiceImpl;
import cn.pioneer.dcim.cmdb.sync.common.CompareUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 定时同步系统用户到neo4j图形数据库的PersonConfigItem表中
 * @create 2018-01-18 17:17
 **/
@Component
public class SysUser2PersonConfigItemJob {
    protected static Logger logger = LoggerFactory.getLogger(SysUser2PersonConfigItemJob.class);
    @Autowired
    PersonServiceImpl personService;
    @Autowired
    SysUserMapper sysUserMapper;

    /**
     * 周期性任务
     */
    @Scheduled(cron = "${sync.person.config.item.job.cron}")
    public void syncPersonConfigItem() {
        logger.info("execute cron job with name " + SysUser2PersonConfigItemJob.class.getSimpleName());
        List<SysUser> sysUsers = sysUserMapper.selectByExample(null);
        List<PersonConfigItem> personConfigItems = personService.findList(null);
        //更新对象列表
        List<PersonConfigItem> needAdd = new ArrayList<>();
        List<PersonConfigItem> needUpdate = new ArrayList<>();
        List<PersonConfigItem> needDelete = new ArrayList<>();
        if (sysUsers == null || sysUsers.size() == 0) {
            if (personConfigItems == null || personConfigItems.size() == 0) {
                logger.warn("关系数据库和图形数据库都没有用户数据，不需要同步");
            } else {
                //全部删除
                personConfigItems.forEach(item -> {
                    needDelete.add(item);
                });
            }
        } else {
            if (personConfigItems == null || personConfigItems.size() == 0) {
                //全部新增
                sysUsers.forEach(sysUser -> {
                    try {
                        PersonConfigItem configItem = new PersonConfigItem();
                        ZZBeanUtils.copyProperties(configItem, sysUser);
                        configItem.setName(sysUser.getRealName());
                        needAdd.add(configItem);
                    } catch (IllegalAccessException e) {
                        logger.error(e.getMessage());
                    } catch (InvocationTargetException e) {
                        logger.error(e.getMessage());
                    }
                });
            } else {
                //交叉更新
                for (SysUser sysUser : sysUsers) {
                    PersonConfigItem matched = null;
                    for (PersonConfigItem personConfigItem : personConfigItems) {
                        if (CompareUtil.equals(sysUser, personConfigItem)) {
                            matched = personConfigItem;
                            break;
                        }
                    }
                    PersonConfigItem configItem = null;
                    try {
                        configItem = new PersonConfigItem();
                        ZZBeanUtils.copyProperties(configItem, sysUser);
                    } catch (IllegalAccessException e) {
                        logger.error(e.getMessage());
                    } catch (InvocationTargetException e) {
                        logger.error(e.getMessage());
                    }
                    if (configItem == null) {
                        continue;
                    }
                    //有匹配的直接更新
                    if (matched != null) {
                        configItem.setName(sysUser.getRealName());
                        configItem.setId(matched.getId());
                        needUpdate.add(configItem);
                    } else {//没有匹配的新增
                        configItem.setDataSource("COSPlat云资源管理平台");
                        needAdd.add(configItem);
                    }
                }

                for (PersonConfigItem personConfigItem : personConfigItems) {
                    boolean match = false;
                    for (SysUser sysUser : sysUsers) {
                        if (CompareUtil.equals(sysUser, personConfigItem)) {
                            match = true;
                            break;
                        }
                    }
                    //没有匹配的删除掉
                    if (!match) {
                        needDelete.add(personConfigItem);
                    }
                }
            }
        }
        //删除
        this.personService.delete(needDelete);
        //新增
        this.personService.save(needAdd);
        //更新
        this.personService.save(needUpdate);

        logger.info(String.format("人员信息同步完成，执行情况：\n新增：%s，删除：%s，更新:%s", needAdd.size(), needDelete.size(), needUpdate.size()));
    }
}
