package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.repositories.ServerRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.List;

/**
 * @author luxinglin
 * @since 2017-01-09
 */
@Service("serverService")
public class ServerServiceImpl implements ConfigItemService<ServerConfigItem> {
    protected Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
    @Autowired
    ServerRepository serverRepository;

    @Override
    public ServerConfigItem save(ServerConfigItem item) {
        if (logger.isDebugEnabled()) {
            logger.debug("to save server item");
        }
        return serverRepository.save(item);
    }

    @Override
    public List<ServerConfigItem> save(List<ServerConfigItem> items) {
        return null;
    }

    @Override
    public void delete(ServerConfigItem item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(List<ServerConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<ServerConfigItem> findList(ServerConfigItem param) {
        return null;
    }

    @Override
    public ServerConfigItem findOne(Long id) {
        return serverRepository.findOne(id);
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        return null;
    }
}
