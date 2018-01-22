package cn.pioneer.dcim.cmdb.services;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;

import java.util.List;
import java.util.Map;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 16:09
 **/
public interface CommConfigItemService {
    /**
     * 获取指定配置项类型下拉框数据源
     *
     * @param type 配置项类型
     * @return
     */
    List<Map<String, Object>> getDropdownList(String type);

    /**
     * 获取配置项类型
     *
     * @return
     */
    List<Map<String, Object>> getConfigItemTypes();

    /**
     * 获取配置项
     *
     * @param type
     * @param id
     * @return
     */
    AbstractConfigItem getConfigItem(String type, Long id);

    /**
     * 获取配置项图形数据
     *
     * @param configType 配置项类型
     * @param id         配置项ID
     * @param limit      显示节点数量
     * @return
     */
    GraphResult graph(String configType, Long id, int limit);
}
