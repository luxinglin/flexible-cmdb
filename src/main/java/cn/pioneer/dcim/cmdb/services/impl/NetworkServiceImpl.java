package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.NetworkConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.repositories.NetworkRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luxinglin
 * @since 2018-01-19
 */
@Service("networkService")
public class NetworkServiceImpl implements ConfigItemService<NetworkConfigItem> {
    @Autowired
    NetworkRepository networkRepository;


    @Override
    public NetworkConfigItem save(NetworkConfigItem item) {
        return networkRepository.save(item);
    }

    @Override
    public List<NetworkConfigItem> save(List<NetworkConfigItem> items) {
        return null;
    }

    @Override
    public void delete(NetworkConfigItem item) {

    }

    @Override
    public void delete(Long id) {
        networkRepository.delete(id);
    }

    @Override
    public void delete(List<NetworkConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<NetworkConfigItem> findList(NetworkConfigItem param) {
        Iterable<NetworkConfigItem> iterable = this.networkRepository.findAll();
        if (iterable == null) {
            return Collections.emptyList();
        }
        List<NetworkConfigItem> result = new ArrayList<>();
        iterable.forEach(item -> {
            result.add(item);
        });
        return result;
    }

    @Override
    public NetworkConfigItem findOne(Long id) {
        return networkRepository.findOne(id);
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        return null;
    }
}
