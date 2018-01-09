package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.common.ToyUtil;
import movies.spring.data.neo4j.common.constants.CiLabelConstant;
import movies.spring.data.neo4j.common.constants.CiRelationConstant;
import movies.spring.data.neo4j.domain.NodeOfBizSystem;
import movies.spring.data.neo4j.domain.RelationOfBelongTo;
import movies.spring.data.neo4j.domain.RelationOfDeployOn;
import movies.spring.data.neo4j.repositories.BizSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BizSystemService {
    @Autowired
    BizSystemRepository bizSystemRepository;


    private Map<String, Object> toD3Format(Collection<NodeOfBizSystem> bizSystems) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<NodeOfBizSystem> result = bizSystems.iterator();
        while (result.hasNext()) {
            NodeOfBizSystem bizSystem = result.next();
            Map<String, Object> nodeAttrMap = ToyUtil.map("title", bizSystem.getName(), "label", CiLabelConstant.BIZSYSTEM);
            nodeAttrMap.put("image", "assets/img/system.svg");
            nodes.add(nodeAttrMap);

            int target = i;
            i++;
            for (RelationOfBelongTo relation : bizSystem.getPersonSet()) {
                Map<String, Object> actor = ToyUtil.map("title", relation.getPerson().getName(), "label", CiLabelConstant.PERSON);
                actor.put("image", "assets/img/person.svg");
                int source = nodes.indexOf(actor);
                if (source == -1) {
                    nodes.add(actor);
                    source = i++;
                }

                Map<String, Object> linkMap = ToyUtil.map("source", source, "target", target);
                linkMap.put("relation", CiRelationConstant.BELONG_TO);
                rels.add(linkMap);
            }

            for (RelationOfDeployOn relation : bizSystem.getServerSet()) {
                Map<String, Object> server = ToyUtil.map("title", relation.getServer().getName(), "label", CiLabelConstant.SERVER);
                server.put("image", "assets/img/Server.svg");
                int source = nodes.indexOf(server);
                if (source == -1) {
                    nodes.add(server);
                    source = i++;
                }
                Map<String, Object> linkMap = ToyUtil.map("source", source, "target", target);
                linkMap.put("relation", CiRelationConstant.DEPLOY_ON);
                rels.add(linkMap);
            }
        }
        return ToyUtil.map("nodes", nodes, "links", rels);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) {
        Collection<NodeOfBizSystem> result = bizSystemRepository.graph(limit);
        return toD3Format(result);
    }

    /**
     *
     * @param name
     * @return
     */
    public Collection<NodeOfBizSystem> findByNameLike(String name){
        Collection<NodeOfBizSystem> bizSystems= bizSystemRepository.findByNameLike(name);
        return bizSystems;
    }

    public void deleteBizSystem(Long id){
         bizSystemRepository.delete(id);
    }
}
