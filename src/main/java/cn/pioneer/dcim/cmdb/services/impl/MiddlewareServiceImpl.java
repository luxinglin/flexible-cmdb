package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.common.graph.GraphLink;
import cn.pioneer.dcim.cmdb.common.graph.GraphNode;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.MiddlewareRunOnRelation;
import cn.pioneer.dcim.cmdb.neo4j.repositories.MiddlewareRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.*;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:01
 **/
@Service("middlewareService")
public class MiddlewareServiceImpl implements ConfigItemService<MiddlewareConfigItem> {
    @Autowired
    MiddlewareRepository middlewareRepository;
    @Autowired
    ConfigItemService<ServerConfigItem> serverService;

    @Override
    public MiddlewareConfigItem save(MiddlewareConfigItem item) {
        //添加运行在主机上的关系
        if (ToyUtil.isNotEmpty(item.getServerIdStr())) {
            ServerConfigItem serverConfigItem = serverService.findOne(Long.valueOf(item.getServerIdStr()));
            if (serverConfigItem != null) {
                MiddlewareRunOnRelation relation = new MiddlewareRunOnRelation();
                relation.setMiddleware(item);
                relation.setServer(serverConfigItem);
                item.getServerSet().add(relation);
            }
        }
        return this.middlewareRepository.save(item);
    }

    @Override
    public List<MiddlewareConfigItem> save(List<MiddlewareConfigItem> items) {
        return null;
    }

    @Override
    public void delete(MiddlewareConfigItem item) {

    }

    @Override
    public void delete(Long id) {
        this.middlewareRepository.delete(id);
    }

    @Override
    public void delete(List<MiddlewareConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<MiddlewareConfigItem> findList(MiddlewareConfigItem param) {
        Iterable<MiddlewareConfigItem> iterable = this.middlewareRepository.findAll();
        if (iterable == null) {
            return Collections.emptyList();
        }
        List<MiddlewareConfigItem> result = new ArrayList<>();
        iterable.forEach(item -> {
            result.add(item);
        });
        return result;
    }

    @Override
    public MiddlewareConfigItem findOne(Long id) {
        return null;
    }

    @Override
    public GraphResult graph(Long id, int limit) {
        Collection<MiddlewareConfigItem> result;
        if (id == null) {
            result = middlewareRepository.graph(limit);
        } else {
            result = middlewareRepository.graph(id, limit);
        }
        return toD3Format(result);
    }

    /**
     * 构造中间件关系图
     *
     * @param middlewareConfigItems
     * @return
     */
    private GraphResult toD3Format(Collection<MiddlewareConfigItem> middlewareConfigItems) {
        GraphResult graphResult = new GraphResult();
        int i = 0;
        Iterator<MiddlewareConfigItem> result = middlewareConfigItems.iterator();
        while (result.hasNext()) {
            MiddlewareConfigItem item = result.next();
            GraphNode graphNode = new GraphNode(item);
            graphResult.getNodes().add(graphNode);
            int target = i;
            i++;
            if (item.getServerSet() != null) {
                for (MiddlewareRunOnRelation relation : item.getServerSet()) {
                    GraphNode node = new GraphNode(relation.getServer());
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
        }
        //通用信息补充
        CmdbUtil.patchGraph(graphResult);

        return graphResult;
    }
}
