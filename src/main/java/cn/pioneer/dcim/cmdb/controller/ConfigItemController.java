package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import cn.pioneer.dcim.cmdb.services.GraphService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 15:12
 **/
@RestController
@RequestMapping("/configItem")
public class ConfigItemController {
    @Autowired
    ConfigItemService configItemService;

    /**
     * 获取系统中支持的配置项类型
     *
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestfulResult getDropdownList() {
        return new RestfulResult(configItemService.getConfigItemTypes());
    }

    /**
     * @param type
     * @return
     */
    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public RestfulResult getDropdownList4Type(@PathVariable String type) {
        return new RestfulResult(configItemService.getDropdownList(type));
    }

    @Autowired
    GraphService graphService;

    @RequestMapping("/graph/{configType}/{id}")
    public RestfulResult graph(@PathVariable String configType, @PathVariable Long id,
                               @RequestParam(value = "limit", required = false) Integer limit) {
        GraphResult graphResult = graphService.graph(configType, id, limit == null ? 100 : limit);
        return new RestfulResult(graphResult);
    }
}
