package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.services.CommConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 配置项通用controller方法
 * @create 2018-01-11 15:12
 **/
@RestController
@RequestMapping("/configItem")
public class ConfigItemController {
    @Autowired
    CommConfigItemService configItemService;


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
     * 获取配置项列表下拉框数据源
     *
     * @param type 配置项类型
     * @return
     */
    @RequestMapping(value = "/{type}", method = RequestMethod.GET)
    public RestfulResult getDropdownList4Type(@PathVariable String type) {
        return new RestfulResult(configItemService.getDropdownList(type));
    }

    /**
     * 获取指定配置项的关系图数据
     *
     * @param configType 配置项类型
     * @param id         配置项ID
     * @param limit      返回节点数量
     * @return
     */
    @RequestMapping("/graph/{configType}/{id}")
    public RestfulResult graph(@PathVariable String configType, @PathVariable Long id,
                               @RequestParam(value = "limit", required = false) Integer limit) {
        GraphResult graphResult = configItemService.graph(configType, id, limit == null ? 100 : limit);
        return new RestfulResult(graphResult);
    }
}
