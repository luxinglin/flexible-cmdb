package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.StorageConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.repositories.StorageRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:00
 **/
@Service("storageService")
public class StorageServiceImpl implements ConfigItemService<StorageConfigItem> {
    @Autowired
    StorageRepository storageRepository;

    @Override
    public StorageConfigItem save(StorageConfigItem item) {
        return storageRepository.save(item);
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
        storageRepository.delete(id);
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
        Iterable<StorageConfigItem> iterable = this.storageRepository.findAll();
        if (iterable == null) {
            return Collections.emptyList();
        }
        List<StorageConfigItem> result = new ArrayList<>();
        iterable.forEach(item -> {
            result.add(item);
        });
        return result;
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
