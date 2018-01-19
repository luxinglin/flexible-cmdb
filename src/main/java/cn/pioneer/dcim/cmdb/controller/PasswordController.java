package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PasswordConfigItem;
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
 * @Description: 密码信息操作类
 * @create 2018-01-15 13:38
 **/
@RestController
@RequestMapping("/passwords")
public class PasswordController {
    @Autowired
    @Qualifier("passwordService")
    ConfigItemService<PasswordConfigItem> passwordService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestfulResult save(PasswordConfigItem passwordConfigItem,
                              HttpServletRequest request) {
        //构造更新信息
        CmdbUtil.patchUpdateInfo(passwordConfigItem, request);
        PasswordConfigItem persist = passwordService.save(passwordConfigItem);
        return new RestfulResult(persist);
    }

    /**
     * @param passwordConfigItem
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestfulResult get(PasswordConfigItem passwordConfigItem,
                             HttpServletRequest request) {
        List<PasswordConfigItem> persist = passwordService.findList(passwordConfigItem);
        return new RestfulResult(persist);
    }

    /**
     * @param id
     * @param request
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestfulResult getOne(@PathVariable("id") Long id,
                                HttpServletRequest request) {

        PasswordConfigItem persist = passwordService.findOne(id);
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
        passwordService.delete(id);
        return new RestfulResult();
    }
}
