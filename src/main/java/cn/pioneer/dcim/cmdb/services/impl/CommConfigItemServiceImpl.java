package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.emun.ConfigTypeEmun;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.neo4j.dao.ConfigItemDao;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.*;
import cn.pioneer.dcim.cmdb.services.CommConfigItemService;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 16:10
 **/
@Service
public class CommConfigItemServiceImpl implements CommConfigItemService {
    @Autowired
    ConfigItemDao configItemDao;
    @Autowired
    @Qualifier("bizSystemService")
    ConfigItemService<BizSystemConfigItem> bizSystemService;
    @Autowired
    @Qualifier("serverService")
    ConfigItemService<ServerConfigItem> serverService;
    @Autowired
    @Qualifier("storageService")
    ConfigItemService<StorageConfigItem> storageService;
    @Autowired
    @Qualifier("networkService")
    ConfigItemService<NetworkConfigItem> networkService;
    @Autowired
    @Qualifier("middlewareService")
    ConfigItemService<MiddlewareConfigItem> middlewareService;
    @Autowired
    @Qualifier("passwordService")
    ConfigItemService<PasswordConfigItem> passwordService;
    @Autowired
    @Qualifier("personService")
    ConfigItemService<PersonConfigItem> personService;

    @Override
    public List<Map<String, Object>> getConfigItemTypes() {
        List<Map<String, Object>> result = new ArrayList<>();
        ConfigTypeEmun[] configTypeEmuns = ConfigTypeEmun.values();
        for (int i = 0; i < configTypeEmuns.length; i++) {
            ConfigTypeEmun item = configTypeEmuns[i];
            result.add(ToyUtil.map("value", item.getCode(), "name", item.getName()));
        }
        return result;
    }

    @Override
    public AbstractConfigItem getConfigItem(String type, Long id) {
        if (ConfigTypeEmun.BIZSYSTEM.getCode().equals(type)) {
            return bizSystemService.findOne(id);
        }
        if (ConfigTypeEmun.SERVER.getCode().equals(type)) {
            return serverService.findOne(id);
        }
        if (ConfigTypeEmun.PASSWORD.getCode().equals(type)) {
            return passwordService.findOne(id);
        }
        if (ConfigTypeEmun.NETWORK.getCode().equals(type)) {
            return networkService.findOne(id);
        }
        if (ConfigTypeEmun.STORAGE.getCode().equals(type)) {
            return storageService.findOne(id);
        }
        if (ConfigTypeEmun.MIDDLEWARE.getCode().equals(type)) {
            return middlewareService.findOne(id);
        }
        if (ConfigTypeEmun.PERSON.getCode().equals(type)) {
            return personService.findOne(id);
        }

        return null;
    }

    @Override
    public List<Map<String, Object>> getDropdownList(String type) {
        List<AbstractConfigItem> list = configItemDao.getDropdownList(type);
        if (list == null || list.size() == 0) {
            return new ArrayList<>();
        }
        List<Map<String, Object>> result = new ArrayList<>();
        list.forEach(item -> {
            Map<String, Object> map = ToyUtil.map("value", item.getId(), "name", item.getName());
            result.add(map);
        });
        return result;
    }

    @Override
    public GraphResult graph(String configType, Long id, int limit) {
        if (ConfigTypeEmun.BIZSYSTEM.getCode().equals(configType)) {
            return bizSystemService.graph(id, limit);
        }
        if (ConfigTypeEmun.PERSON.getCode().equals(configType)) {
            return personService.graph(id, limit);
        }
        if (ConfigTypeEmun.MIDDLEWARE.getCode().equals(configType)) {
            return middlewareService.graph(id, limit);
        }
        if (ConfigTypeEmun.STORAGE.getCode().equals(configType)) {
            return storageService.graph(id, limit);
        }
        if (ConfigTypeEmun.NETWORK.getCode().equals(configType)) {
            return networkService.graph(id, limit);
        }
        if (ConfigTypeEmun.PASSWORD.getCode().equals(configType)) {
            return passwordService.graph(id, limit);
        }
        if (ConfigTypeEmun.SERVER.getCode().equals(configType)) {
            return serverService.graph(id, limit);
        }
        return null;
    }
}
