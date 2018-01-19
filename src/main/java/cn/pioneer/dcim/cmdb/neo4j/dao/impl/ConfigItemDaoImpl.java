package cn.pioneer.dcim.cmdb.neo4j.dao.impl;

import cn.pioneer.dcim.cmdb.neo4j.dao.ConfigItemDao;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.*;
import org.neo4j.ogm.session.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import static cn.pioneer.dcim.cmdb.common.util.ToyUtil.isSpecifyType;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 15:15
 **/
@Repository
public class ConfigItemDaoImpl implements ConfigItemDao {
    protected static Logger logger = LoggerFactory.getLogger(ConfigItemDaoImpl.class);
    @Autowired
    Session session;

    @Override
    public List<AbstractConfigItem> getDropdownList(String type) {
        List<AbstractConfigItem> results = new ArrayList<>();

        Collection its = null;
        if (isSpecifyType(BizSystemConfigItem.class, type)) {
            its = session.loadAll(BizSystemConfigItem.class);
        } else if (isSpecifyType(NetworkConfigItem.class, type)) {
            its = session.loadAll(NetworkConfigItem.class);
        } else if (isSpecifyType(PasswordConfigItem.class, type)) {
            its = session.loadAll(PasswordConfigItem.class);
        } else if (isSpecifyType(ServerConfigItem.class, type)) {
            its = session.loadAll(ServerConfigItem.class);
        } else if (isSpecifyType(StorageConfigItem.class, type)) {
            its = session.loadAll(StorageConfigItem.class);
        } else if (isSpecifyType(MiddlewareConfigItem.class, type)) {
            its = session.loadAll(MiddlewareConfigItem.class);
        } else if (isSpecifyType(PersonConfigItem.class, type)) {
            its = session.loadAll(PersonConfigItem.class);
        }

        if (its != null && its.size() > 0) {
            its.forEach((it) -> results.add((AbstractConfigItem) it));
        }
        return results;
    }
}
