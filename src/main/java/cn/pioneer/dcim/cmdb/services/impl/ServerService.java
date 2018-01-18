package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.repositories.ServerRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemAble;
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
@Service
public class ServerService implements ConfigItemAble<ServerConfigItem> {
    protected Logger logger = LoggerFactory.getLogger(ServerService.class);
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
}
