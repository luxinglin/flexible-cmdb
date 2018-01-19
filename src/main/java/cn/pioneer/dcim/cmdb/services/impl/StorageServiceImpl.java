package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.StorageConfigItem;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:00
 **/
@Service("storageService")
public class StorageServiceImpl implements ConfigItemService<StorageConfigItem> {

    @Override
    public StorageConfigItem save(StorageConfigItem item) {
        return null;
    }

    @Override
    public List<StorageConfigItem> save(List<StorageConfigItem> items) {
        return null;
    }

    @Override
    public void delete(StorageConfigItem item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(List<StorageConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<StorageConfigItem> findList(StorageConfigItem param) {
        return null;
    }

    @Override
    public StorageConfigItem findOne(Long id) {
        return null;
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        return null;
    }
}
