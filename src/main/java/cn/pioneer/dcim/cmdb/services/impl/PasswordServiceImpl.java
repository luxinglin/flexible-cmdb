package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PasswordConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.PasswordForRelation;
import cn.pioneer.dcim.cmdb.neo4j.repositories.PasswordRepository;
import cn.pioneer.dcim.cmdb.services.CommConfigItemService;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
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
@Service("passwordService")
public class PasswordServiceImpl implements ConfigItemService<PasswordConfigItem> {
    protected static Logger logger = LoggerFactory.getLogger(PasswordServiceImpl.class);
    @Autowired
    PasswordRepository passwordRepository;
    @Autowired
    ServerServiceImpl serverService;
    @Autowired
    BizSystemServiceImpl bizSystemService;
    @Autowired
    CommConfigItemService commConfigItemService;

    @Override
    public PasswordConfigItem save(PasswordConfigItem item) {
        List<AbstractConfigItem> list = new ArrayList<>(8);
        if (ToyUtil.isNotEmpty(item.getConfigItemType())) {
            AbstractConfigItem abstractConfigItem = commConfigItemService.getConfigItem(item.getConfigItemType(), item.getConfigItemId());
            PasswordForRelation passwordForRelation = new PasswordForRelation();
            passwordForRelation.setPasswordConfigItem(item);
            passwordForRelation.setAbstractConfigItem(abstractConfigItem);
            item.getPasswordForRelations().add(passwordForRelation);
        }

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

    @Override
    public GraphResult graph(Long id, int limit) {
        return null;
    }
}
