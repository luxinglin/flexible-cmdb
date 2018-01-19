package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 15:24
 **/
@RestController
@RequestMapping("middlewares")
public class MiddlewareController {
    @Autowired
    @Qualifier("middlewareService")
    ConfigItemService<MiddlewareConfigItem> middlewareService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestfulResult save(MiddlewareConfigItem configItem,
                              HttpServletRequest request) {
        //构造更新信息
        CmdbUtil.patchUpdateInfo(configItem, request);
        MiddlewareConfigItem persist = middlewareService.save(configItem);
        return new RestfulResult(persist);
    }

    /**
     * @param configItem
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestfulResult get(MiddlewareConfigItem configItem,
                             HttpServletRequest request) {
        List<MiddlewareConfigItem> persist = middlewareService.findList(configItem);
        return new RestfulResult(persist);
    }

    /**
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestfulResult delete(@PathVariable("id") Long id,
                                HttpServletRequest request) {
        middlewareService.delete(id);
        return new RestfulResult();
    }
}
