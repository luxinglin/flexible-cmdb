package movies.spring.data.neo4j.controller;

import movies.spring.data.neo4j.domain.BizSystem;
import movies.spring.data.neo4j.domain.Person;
import movies.spring.data.neo4j.repositories.BizSystemRepository;
import movies.spring.data.neo4j.repositories.PersonRepository;
import movies.spring.data.neo4j.services.BizSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "", method = RequestMethod.POST)
    @Transactional
    public BizSystem saveTask(BizSystem bizSystem) {
        List<Person> personList = new ArrayList<>();
        personList.add(personRepository.findOne(20L));
        personList.add(personRepository.findOne(24L));
        bizSystem.setPersonList(personList);
        BizSystem system = bizSystemRepository.save(bizSystem);

        return system;
    }

    @RequestMapping(value = "/{name}", method = RequestMethod.GET)
    public BizSystem getBizSytem(@PathVariable String name) {
        BizSystem bizSystem = bizSystemRepository.findByName(name);
        return bizSystem;
    }

    @RequestMapping("/graph")
    public Map<String, Object> graph(@RequestParam(value = "limit", required = false) Integer limit) {
        return bizSystemService.graph(limit == null ? 100 : limit);
    }
}
