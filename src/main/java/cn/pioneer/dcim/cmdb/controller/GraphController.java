package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.services.impl.BizSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

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
    BizSystemService bizSystemService;

    @RequestMapping("/BizSystem/{id}")
    public Map<String, Object> graph(@PathVariable Long id,
                                     @RequestParam(value = "limit", required = false) Integer limit) {
        return bizSystemService.graph(id, limit == null ? 100 : limit);
    }
}
