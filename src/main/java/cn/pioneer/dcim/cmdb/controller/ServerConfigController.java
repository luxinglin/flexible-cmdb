package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.services.impl.ServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-12 18:04
 **/
@RestController
@RequestMapping("/servers")
public class ServerConfigController {
    @Autowired
    ServerService serverService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestfulResult save(ServerConfigItem serverConfigItem,
                              HttpServletRequest request) {
        //构造更新信息
        CmdbUtil.patchUpdateInfo(serverConfigItem, request);
        ServerConfigItem persist = serverService.save(serverConfigItem);
        return new RestfulResult(persist);
    }
}
