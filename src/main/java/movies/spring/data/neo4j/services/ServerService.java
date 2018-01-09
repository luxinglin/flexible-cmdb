package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.common.util.PatchUpdateInfoUtil;
import movies.spring.data.neo4j.domain.NodeOfServer;
import movies.spring.data.neo4j.repositories.ServerRepository;
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
    public NodeOfServer addNodeOfServer(NodeOfServer nodeOfServer) {
        if (logger.isDebugEnabled()) {
            logger.debug(nodeOfServer.toString());
        }
        PatchUpdateInfoUtil.patch(nodeOfServer);
        NodeOfServer persist = serverRepository.save(nodeOfServer);
        logger.info("add NodeOfServer successfully");
        return persist;
    }
}
