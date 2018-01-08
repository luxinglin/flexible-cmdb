package movies.spring.data.neo4j.services;

import movies.spring.data.neo4j.common.ToyUtil;
import movies.spring.data.neo4j.domain.BizSystem;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.repositories.BizSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
public class BizSystemService {
    @Autowired
    BizSystemRepository bizSystemRepository;


    private Map<String, Object> toD3Format(Collection<BizSystem> bizSystems) {
        List<Map<String, Object>> nodes = new ArrayList<>();
        List<Map<String, Object>> rels = new ArrayList<>();
        int i = 0;
        Iterator<BizSystem> result = bizSystems.iterator();
        while (result.hasNext()) {
            BizSystem movie = result.next();
            Map<String,Object> nodeAttrMap =ToyUtil.map("title", movie.getName(), "label", "movie");
            nodeAttrMap.put("image","assets/img/system.svg");
            nodes.add(nodeAttrMap);

            int target = i;
            i++;
            for (Person person : movie.getPersonList()) {
                Map<String, Object> actor = ToyUtil.map("title", person.getName(), "label", "actor");
                actor.put("image","assets/img/logo-white.svg");
                int source = nodes.indexOf(actor);
                if (source == -1) {
                    nodes.add(actor);
                    source = i++;
                }
                rels.add(ToyUtil.map("source", source, "target", target));
            }
        }
        return ToyUtil.map("nodes", nodes, "links", rels);
    }

    @Transactional(readOnly = true)
    public Map<String, Object> graph(int limit) {
        Collection<BizSystem> result = bizSystemRepository.graph(limit);
        return toD3Format(result);
    }
}
