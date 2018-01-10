package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.domain.entity.NetworkConfigItem;
import cn.pioneer.dcim.cmdb.repositories.NetworkRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NetworkService {
    @Autowired
    NetworkRepository networkRepository;

    public NetworkConfigItem addNodeOfNetwork(NetworkConfigItem nodeOfNetwork) {
        NetworkConfigItem persist = networkRepository.save(nodeOfNetwork);
        return persist;
    }

}
