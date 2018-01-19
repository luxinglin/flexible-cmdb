package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-15 11:46
 **/
@RestController
@RequestMapping("/graph")
public class GraphController {
    @Autowired
    GraphService graphService;

    @RequestMapping("/{configType}/{id}")
    public RestfulResult graph(@PathVariable String configType, @PathVariable Long id,
                               @RequestParam(value = "limit", required = false) Integer limit) {
        GraphResult graphResult = graphService.graph(configType, id, limit == null ? 100 : limit);
        return new RestfulResult(graphResult);
    }
}
