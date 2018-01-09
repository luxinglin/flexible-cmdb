package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.*;
import movies.spring.data.neo4j.repositories.BizSystemRepository;
import movies.spring.data.neo4j.repositories.PersonRepository;
import movies.spring.data.neo4j.services.BizSystemService;
import movies.spring.data.neo4j.services.NetworkService;
import movies.spring.data.neo4j.services.ServerService;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @author luxinglin
 * @since 2018-01-08
 */
@RestController
@RequestMapping("/bizSystem")
public class BizSystemController {
    @Autowired
    BizSystemRepository bizSystemRepository;
    @Autowired
    BizSystemService bizSystemService;
    @Autowired
    PersonRepository personRepository;
    @Autowired
    ServerService serverService;
    @Autowired
    NetworkService networkService;

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Transactional
    public NodeOfBizSystem saveTask(NodeOfBizSystem bizSystem) {

        NodeOfNetwork nodeOfNetwork = new NodeOfNetwork();
        nodeOfNetwork.setName("网络交换机1");
        nodeOfNetwork.setSn("sn.network.20180109." + RandomUtils.nextInt(1, 1000));
        nodeOfNetwork = networkService.addNodeOfNetwork(nodeOfNetwork);
        List<NodeOfNetwork> networks = new ArrayList<>();
        networks.add(nodeOfNetwork);

        NodeOfServer nodeOfServer = new NodeOfServer();
        nodeOfServer.setUuid(UUID.randomUUID().toString());
        nodeOfServer.setName("Server1_" + RandomStringUtils.random(5));
        nodeOfServer.setSn("exp.oxoox01039." + RandomUtils.nextInt(1, 1000));
        nodeOfServer.setNetworks(networks);
        serverService.addNodeOfServer(nodeOfServer);

        //归属某个人管理
        Set<RelationOfBelongTo> personList = new HashSet<>();
        RelationOfBelongTo belongTo = new RelationOfBelongTo();
        belongTo.setBizSystem(bizSystem);
        belongTo.setPerson(personRepository.findOne(20L));
        personList.add(belongTo);
        bizSystem.setPersonSet(personList);

        //部署在xx系统上
        RelationOfDeployOn relationOfDeployOn = new RelationOfDeployOn();
        relationOfDeployOn.setBizSystem(bizSystem);
        relationOfDeployOn.setServer(nodeOfServer);

        Set<RelationOfDeployOn> deployOnSet = new HashSet<>();
        deployOnSet.add(relationOfDeployOn);

        bizSystem.setServerSet(deployOnSet);

        bizSystem = bizSystemRepository.save(bizSystem);
        return bizSystem;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public NodeOfBizSystem getBizSytem(@PathVariable String name) {
        NodeOfBizSystem bizSystem = bizSystemRepository.findByName(name);
        return bizSystem;
    }

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        return bizSystemService.graph(limit == null ? 100 : limit);
    }

    @RequestMapping(value = "/findByNameLike", method = RequestMethod.GET)
    public List findByNameLike(@RequestParam(value = "name", required = false) String name) {
        List bizSystem = (List) bizSystemService.findByNameLike(name);
        return bizSystem;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Map<String, Object> delete(@PathVariable Long id) {
        bizSystemService.deleteBizSystem(id);
        return new HashMap<>();
    }
}
