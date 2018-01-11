package cn.pioneer.dcim.cmdb.services;

import java.util.List;
import java.util.Map;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 16:09
 **/
public interface ConfigItemService {
    /**
     * @param type
     * @return
     */
    List<Map<String, Object>> getDropdownList(String type);

    /**
     * @return
     */
    List<Map<String, Object>> getConfigItemTypes();
}
