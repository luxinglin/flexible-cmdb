package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.constants.CommonConstant;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.PasswordConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.PasswordForRelation;
import cn.pioneer.dcim.cmdb.repositories.PasswordRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-15 13:39
 **/
@Service
public class PasswordService implements ConfigItemAble<PasswordConfigItem> {
    protected static Logger logger = LoggerFactory.getLogger(PasswordService.class);

    @Autowired
    PasswordRepository passwordRepository;
    @Autowired
    ServerService serverService;
    @Autowired
    BizSystemService bizSystemService;

    @Override
    public PasswordConfigItem save(PasswordConfigItem item) {
        List<AbstractConfigItem> list = new ArrayList<>(8);
        if (ToyUtil.isNotEmpty(item.getServerIdStr())) {
            String[] servers = item.getServerIdStr().split(CommonConstant.COMMA);
            for (int i = 0; i < servers.length; i++) {
                ServerConfigItem serverConfigItem = serverService.findOne(Long.valueOf(servers[i]));
                if (serverConfigItem != null) {
                    list.add(serverConfigItem);
                }
            }
        }
        if (ToyUtil.isNotEmpty(item.getBizSystemIdStr())) {
            String[] bizSystems = item.getBizSystemIdStr().split(CommonConstant.COMMA);
            for (int i = 0; i < bizSystems.length; i++) {
                BizSystemConfigItem bizSystemConfigItem = bizSystemService.findOne(Long.valueOf(bizSystems[i]));
                if (bizSystemConfigItem != null) {
                    list.add(bizSystemConfigItem);
                }
            }
        }

        //关系构造
        list.forEach(innerItem -> {
            PasswordForRelation passwordForRelation = new PasswordForRelation();
            passwordForRelation.setPasswordConfigItem(item);
            passwordForRelation.setAbstractConfigItem(innerItem);
            item.getPasswordForRelations().add(passwordForRelation);
        });
        if (logger.isDebugEnabled()) {
            logger.debug("构造信息完成");
        }

        //实体保存
        return passwordRepository.save(item);
    }

    @Override
    public List<PasswordConfigItem> save(List<PasswordConfigItem> items) {
        return null;
    }

    @Override
    public void delete(PasswordConfigItem item) {

    }

    @Override
    public void delete(Long id) {
        this.passwordRepository.delete(id);
    }

    @Override
    public void delete(List<PasswordConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<PasswordConfigItem> findList(PasswordConfigItem param) {
        Iterable<PasswordConfigItem> items = passwordRepository.findAll();
        List<PasswordConfigItem> list = new ArrayList<>();
        items.forEach(item -> list.add(item));
        return list;
    }

    @Override
    public PasswordConfigItem findOne(Long id) {
        return passwordRepository.findOne(id);
    }
}
