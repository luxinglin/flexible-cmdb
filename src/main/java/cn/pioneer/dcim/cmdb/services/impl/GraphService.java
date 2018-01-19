package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.emun.ConfigTypeEmun;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 10:26
 **/
@Service
public class GraphService implements cn.pioneer.dcim.cmdb.services.GraphService {
    @Autowired
    BizSystemService bizSystemService;


    @Override
    public GraphResult graph(String configType, Long id, int limit) {
        if (ConfigTypeEmun.BIZSYSTEM.getCode().equals(configType)) {
            return bizSystemService.graph(id, limit);
        }
        return null;
    }
}
