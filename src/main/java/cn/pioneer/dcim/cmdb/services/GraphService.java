package cn.pioneer.dcim.cmdb.services;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 10:25
 **/
public interface GraphService {
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
