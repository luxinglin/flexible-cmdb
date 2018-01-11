package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
}
