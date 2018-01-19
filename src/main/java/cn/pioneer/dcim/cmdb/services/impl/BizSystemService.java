package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.common.constants.CommonConst;
import cn.pioneer.dcim.cmdb.common.graph.GraphLink;
import cn.pioneer.dcim.cmdb.common.graph.GraphNode;
import cn.pioneer.dcim.cmdb.common.graph.GraphResult;
import cn.pioneer.dcim.cmdb.common.util.CmdbUtil;
import cn.pioneer.dcim.cmdb.common.util.ToyUtil;
import cn.pioneer.dcim.cmdb.dao.BizSystemDao;
import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.DeployOnRelation;
import cn.pioneer.dcim.cmdb.domain.relationship.OwnedRelation;
import cn.pioneer.dcim.cmdb.repositories.BizSystemRepository;
import cn.pioneer.dcim.cmdb.repositories.PersonRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemAble;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
@Service
public class BizSystemService implements ConfigItemAble<BizSystemConfigItem> {
    protected static Logger logger = LoggerFactory.getLogger(BizSystemService.class);
    @Autowired
    BizSystemRepository bizSystemRepository;
    @Autowired
    BizSystemDao bizSystemDao;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ServerService serverService;

    /**
     * 构建业务系统人员关系
     *
     * @param item
     */
    private void constructBizSystemPersonRelation(BizSystemConfigItem item) {
        //业务接口人信息
        if (ToyUtil.isNotEmpty(item.getBizContactIdStr())) {
            String[] persons = item.getBizContactIdStr().split(CommonConst.COMMA);
            List<PersonConfigItem> personList = new ArrayList<>(persons.length);
            for (int i = 0; i < persons.length; i++) {
                PersonConfigItem person = this.personRepository.findOne(Long.valueOf(persons[i]));
                if (person != null) {
                    personList.add(person);
                }
            }
            personList.forEach(person -> {
                OwnedRelation belongToRelation = new OwnedRelation();
                belongToRelation.setAbstractEntity(item);
                belongToRelation.setPerson(person);
                belongToRelation.setRemark("业务接口人");
                item.getOwnedRelationSet().add(belongToRelation);
            });
        }
        if (ToyUtil.isNotEmpty(item.getBizRelationIdStr())) {
            String[] persons = item.getBizRelationIdStr().split(CommonConst.COMMA);
            List<PersonConfigItem> personList = new ArrayList<>(persons.length);
            for (int i = 0; i < persons.length; i++) {
                PersonConfigItem person = this.personRepository.findOne(Long.valueOf(persons[i]));
                if (person != null) {
                    personList.add(person);
                }
            }
            personList.forEach(person -> {
                OwnedRelation belongToRelation = new OwnedRelation();
                belongToRelation.setAbstractEntity(item);
                belongToRelation.setPerson(person);
                belongToRelation.setRemark("业务关系人");
                item.getOwnedRelationSet().add(belongToRelation);
            });
        }
    }

    @Override
    public BizSystemConfigItem save(BizSystemConfigItem item) {
        constructBizSystemPersonRelation(item);

        //部署关系非空
        if (ToyUtil.isNotEmpty(item.getServerIdStr())) {
            String[] servers = item.getServerIdStr().split(CommonConst.COMMA);
            List<ServerConfigItem> serverConfigItems = new ArrayList<>(servers.length);
            for (int i = 0; i < servers.length; i++) {
                ServerConfigItem serverConfigItem = this.serverService.findOne(Long.valueOf(servers[i]));
                if (serverConfigItems != null) {
                    serverConfigItems.add(serverConfigItem);
                }
            }
            serverConfigItems.forEach(serverConfigItem -> {
                DeployOnRelation deployOnRelation = new DeployOnRelation();
                deployOnRelation.setBizSystem(item);
                deployOnRelation.setServer(serverConfigItem);
                item.getServerSet().add(deployOnRelation);
            });
        }

        BizSystemConfigItem persist = bizSystemRepository.save(item);
        return persist;
    }

    @Override
    public List<BizSystemConfigItem> save(List<BizSystemConfigItem> items) {
        return null;
    }

    @Override
    public void delete(BizSystemConfigItem item) {

    }

    @Override
    public void delete(Long id) {
        if (!ToyUtil.validID(id)) {
            logger.error("业务系统删除失败，ID值不合法");
            return;
        }
        if (!bizSystemRepository.exists(id)) {
            logger.error("业务系统删除失败，指定ID的业务系统不存在");
            return;
        }
        this.bizSystemRepository.delete(id);
        logger.info("业务系统删除成功");
    }

    @Override
    public void delete(List<BizSystemConfigItem> items) {

    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<BizSystemConfigItem> findList(BizSystemConfigItem param) {
        List list = bizSystemDao.queryBizSystemConfigItemByPerproty(param);
        return list;
    }

    @Override
    public BizSystemConfigItem findOne(Long id) {
        return this.bizSystemRepository.findOne(id);
    }

    private GraphResult toD3Format(Collection<BizSystemConfigItem> bizSystems) {
        GraphResult graphResult = new GraphResult();
        int i = 0;
        Iterator<BizSystemConfigItem> result = bizSystems.iterator();
        while (result.hasNext()) {
            BizSystemConfigItem bizSystem = result.next();
            GraphNode graphNode = new GraphNode(bizSystem);
            graphResult.getNodes().add(graphNode);

            int target = i;
            i++;
            if (bizSystem.getServerSet() != null) {
                for (DeployOnRelation relation : bizSystem.getServerSet()) {
                    GraphNode node = new GraphNode(relation.getServer());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.DEPLOY_ON);
                    graphResult.getLinks().add(graphLink);
                }
            }
            if (bizSystem.getOwnedRelationSet() != null) {
                for (OwnedRelation relation : bizSystem.getOwnedRelationSet()) {
                    GraphNode node = new GraphNode(relation.getPerson());
                    int source = graphResult.getNodes().indexOf(node);
                    if (source == -1) {
                        graphResult.getNodes().add(node);
                        source = i++;
                    }
                    GraphLink graphLink = new GraphLink(source, target);
                    graphLink.setRelation(CiRelationConst.OWNED);
                    graphResult.getLinks().add(graphLink);
                }
            }
        }
        //通用信息补充
        CmdbUtil.patchGraph(graphResult);

        return graphResult;
    }

    @Transactional(readOnly = true)
    public GraphResult graph(Long id, int limit) {
        Collection<BizSystemConfigItem> result;
        if (id == null) {
            result = bizSystemRepository.graph(limit);
        } else {
            result = bizSystemRepository.graph(id, limit);
        }
        return toD3Format(result);

    }

    /**
     * @param name
     * @return
     */
    public Collection<BizSystemConfigItem> findByNameLike(String name) {
        Collection<BizSystemConfigItem> bizSystems = bizSystemRepository.findByNameLike(name);
        return bizSystems;
    }

}
