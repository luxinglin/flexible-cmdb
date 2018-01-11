package cn.pioneer.dcim.cmdb.dao;

import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;

import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 15:15
 **/
public interface ConfigItemDao {
    List<AbstractConfigItem> getDropdownList(String type);
}
