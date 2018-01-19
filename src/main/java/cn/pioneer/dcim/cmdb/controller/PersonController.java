package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 15:25
 **/
@RestController
@RequestMapping("/persons")
public class PersonController {
    @Autowired
    @Qualifier("personService")
    ConfigItemService<PersonConfigItem> personService;

    /**
     * @param configItem
     * @param request
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.GET)
    public RestfulResult get(PersonConfigItem configItem,
                             HttpServletRequest request) {
        List<PersonConfigItem> persist = personService.findList(configItem);
        return new RestfulResult(persist);
    }
}
