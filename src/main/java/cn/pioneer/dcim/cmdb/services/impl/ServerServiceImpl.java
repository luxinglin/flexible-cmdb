package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.common.constants.CommConst;
import cn.pioneer.dcim.cmdb.common.graph.GraphLink;
import cn.pioneer.dcim.cmdb.common.graph.GraphNode;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.NetworkConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.StorageConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.*;
import cn.pioneer.dcim.cmdb.neo4j.repositories.ServerRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

/**
 * @author luxinglin
 * @since 2017-01-09
 */
@Service("serverService")
public class ServerServiceImpl implements ConfigItemService<ServerConfigItem> {
    protected Logger logger = LoggerFactory.getLogger(ServerServiceImpl.class);
    @Autowired
    ServerRepository serverRepository;
    @Autowired
    ConfigItemService<PersonConfigItem> personService;
    @Autowired
    ConfigItemService<NetworkConfigItem> networkService;
    @Autowired
    ConfigItemService<StorageConfigItem> storageService;

    @Override
    public ServerConfigItem save(ServerConfigItem item) {
        if (logger.isDebugEnabled()) {
            logger.debug("to save server item");
        }
        if (ToyUtil.isNotEmpty(item.getOwnerIdStr())) {
            PersonConfigItem personConfigItem = personService.findOne(Long.valueOf(item.getOwnerIdStr()));
            OwnedRelation ownedRelation = new OwnedRelation();
            ownedRelation.setAbstractEntity(item);
            ownedRelation.setPerson(personConfigItem);
            item.getOwnedRelationSet().add(ownedRelation);
        }
        if (ToyUtil.isNotEmpty(item.getNetworkIdStr())) {
            String[] idArr = item.getNetworkIdStr().split(CommConst.COMMA);
            for (int idx = 0; idx < idArr.length; idx++) {
                NetworkLinkRelation networkLinkRelation = new NetworkLinkRelation();
                networkLinkRelation.setNetwork(networkService.findOne(Long.valueOf(idArr[idx])));
                networkLinkRelation.setLinkTarget(item);
            }
        }
        if (ToyUtil.isNotEmpty(item.getStorageIdStr())) {
            String[] idArr = item.getStorageIdStr().split(CommConst.COMMA);
            for (int idx = 0; idx < idArr.length; idx++) {
                StorageLinkRelation networkLinkRelation = new StorageLinkRelation();
                networkLinkRelation.setStorage(storageService.findOne(Long.valueOf(idArr[idx])));
                networkLinkRelation.setServer(item);

            }
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
        this.serverRepository.delete(id);
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
        Iterable<ServerConfigItem> iterable = this.serverRepository.findAll();
        if (iterable == null) {
            return Collections.emptyList();
        }
        List<ServerConfigItem> result = new ArrayList<>();
        iterable.forEach(item -> {
            result.add(item);
        });
        return result;
    }

    @Override
    public ServerConfigItem findOne(Long id) {
        return serverRepository.findOne(id);
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        Collection<ServerConfigItem> result;
        if (id == null) {
            result = serverRepository.graph(limit);
        } else {
            result = serverRepository.graph(id, limit);
        }
        return toD3Format(result);
    }

    private GraphResult toD3Format(Collection<ServerConfigItem> serverConfigItems) {
        GraphResult graphResult = new GraphResult();
        int i = 0;
        Iterator<ServerConfigItem> result = serverConfigItems.iterator();
        while (result.hasNext()) {
            ServerConfigItem item = result.next();
            GraphNode graphNode = new GraphNode(item);
            graphResult.getNodes().add(graphNode);
            int target = i;
            i++;
            //虚机关系
            if (item.getServerSet() != null) {
                for (VirtualOnRelation relation : item.getServerSet()) {
                    GraphNode node = new GraphNode(relation.getVirtalMachine());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.VIRTUAL_ON);
                    graphResult.getLinks().add(graphLink);
                }
            }
            //中间件信息
            if (item.getMiddlewares() != null) {
                for (MiddlewareRunOnRelation relation : item.getMiddlewares()) {
                    GraphNode node = new GraphNode(relation.getMiddleware());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.MIDDLEWARE_RUN_ON);
                    graphResult.getLinks().add(graphLink);
                }
            }
            //网络设备连接
            if (item.getNetworks() != null) {
                for (NetworkLinkRelation relation : item.getNetworks()) {
                    GraphNode node = new GraphNode(relation.getNetwork());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.NETWORK_LINK);
                    graphResult.getLinks().add(graphLink);
                }
            }
            //存储设备连接
            if (item.getStorages() != null) {
                for (StorageLinkRelation relation : item.getStorages()) {
                    GraphNode node = new GraphNode(relation.getStorage());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.STORAGE_LINK);
                    graphResult.getLinks().add(graphLink);
                }
            }
        }
        //通用信息补充
        CmdbUtil.patchGraph(graphResult);

        return graphResult;
    }
}
