package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:01
 **/
@Service("middlewareService")
public class MiddlewareServiceImpl implements ConfigItemService<MiddlewareConfigItem> {
    @Override
    public MiddlewareConfigItem save(MiddlewareConfigItem item) {
        return null;
    }

    @Override
    public List<MiddlewareConfigItem> save(List<MiddlewareConfigItem> items) {
        return null;
    }

    @Override
    public void delete(MiddlewareConfigItem item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(List<MiddlewareConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<MiddlewareConfigItem> findList(MiddlewareConfigItem param) {
        return null;
    }

    @Override
    public MiddlewareConfigItem findOne(Long id) {
        return null;
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        return null;
    }
}
