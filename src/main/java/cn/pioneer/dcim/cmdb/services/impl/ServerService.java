package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.repositories.ServerRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author luxinglin
 * @since 2017-01-09
 */
@Service
public class ServerService {
    protected Logger logger = LoggerFactory.getLogger(ServerService.class);
    @Autowired
    ServerRepository serverRepository;

    /**
     * 新增node
     *
     * @param nodeOfServer
     * @return
     */
    public ServerConfigItem addNodeOfServer(ServerConfigItem nodeOfServer) {
        if (logger.isDebugEnabled()) {
            logger.debug(nodeOfServer.toString());
        }
        ServerConfigItem persist = serverRepository.save(nodeOfServer);
        logger.info("add NodeOfServer successfully");
        return persist;
    }
}
