package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.emun.ConfigTypeEmun;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.dao.ConfigItemDao;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
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
public class ConfigItemServiceImpl implements ConfigItemService {
    @Autowired
    ConfigItemDao configItemDao;

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


}
