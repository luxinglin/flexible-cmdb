package cn.pioneer.dcim.cmdb.controller;

import cn.pioneer.dcim.cmdb.common.RestfulResult;
import cn.pioneer.dcim.cmdb.common.util.PatchUpdateInfoUtil;
import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.services.impl.BizSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * 业务系统操作类
 *
 * @author luxinglin
 * @since 2018-01-08
 */
@RestController
@RequestMapping("/bizSystem")
public class BizSystemController {
    @Autowired
    BizSystemService bizSystemService;

    /**
     * 新增业务系统
     *
     * @param bizSystem 业务系统参数
     * @param request   请求头
     * @return
     */
    @RequestMapping(value = "", method = RequestMethod.POST)
    public RestfulResult save(BizSystemConfigItem bizSystem,
                              HttpServletRequest request) {
        //构造更新信息
        PatchUpdateInfoUtil.patch(bizSystem, request);
        BizSystemConfigItem persist = bizSystemService.save(bizSystem);
        return new RestfulResult(persist);
    }

    /**
     * 查找单个配置项
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public RestfulResult findOne(@PathVariable Long id) {
        return new RestfulResult(bizSystemService.findOne(id));
    }

    /**
     * 列表查询
     *
     * @param bizSystemConfigItem
     * @return
     */
    @RequestMapping(value = "/findList", method = RequestMethod.GET)
    public RestfulResult findList(BizSystemConfigItem bizSystemConfigItem) {
        return new RestfulResult(bizSystemService.findList(bizSystemConfigItem));
    }

    /**
     * 删除指定配置项
     *
     * @param id
     * @return
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public RestfulResult delete(@PathVariable Long id) {
        bizSystemService.delete(id);
        return new RestfulResult();
    }

    /**
     * 图形数据查找
     *
     * @param limit
     * @return
     */
    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        return bizSystemService.graph(limit == null ? 100 : limit);
    }
}
