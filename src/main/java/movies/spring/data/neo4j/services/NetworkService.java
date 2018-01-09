package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.common.util.PatchUpdateInfoUtil;
import movies.spring.data.neo4j.domain.NodeOfNetwork;
import movies.spring.data.neo4j.repositories.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {
    @Autowired
    NetworkRepository networkRepository;

    public NodeOfNetwork addNodeOfNetwork(NodeOfNetwork nodeOfNetwork) {
        PatchUpdateInfoUtil.patch(nodeOfNetwork);
        NodeOfNetwork persist = networkRepository.save(nodeOfNetwork);
        return persist;
    }

}
