package cn.pioneer.dcim.cmdb.services.impl;

import cn.pioneer.dcim.cmdb.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.repositories.PersonRepository;
import cn.pioneer.dcim.cmdb.services.ConfigItemAble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.awt.print.Pageable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-18 17:21
 **/
@Service
public class PersonService implements ConfigItemAble<PersonConfigItem> {
    @Autowired
    PersonRepository personRepository;

    @Override
    public PersonConfigItem save(PersonConfigItem item) {
        return null;
    }

    @Override
    public List<PersonConfigItem> save(List<PersonConfigItem> items) {
        Iterable<PersonConfigItem> results = this.personRepository.save(items);
        List<PersonConfigItem> list = new ArrayList<>();
        results.forEach(result -> list.add(result));
        return list;
    }

    @Override
    public void delete(PersonConfigItem item) {

    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public void delete(List<PersonConfigItem> items) {
        this.personRepository.delete(items);
    }

    @Override
    public Pageable page(Pageable pageable) {
        return null;
    }

    @Override
    public List<PersonConfigItem> findList(PersonConfigItem param) {
        Iterable<PersonConfigItem> iterable = personRepository.findAll();
        if (iterable == null || !iterable.iterator().hasNext()) {
            return Collections.emptyList();
        }
        List<PersonConfigItem> configItems = new ArrayList<>();
        iterable.forEach(item -> configItems.add(item));
        return configItems;
    }

    @Override
    public PersonConfigItem findOne(Long id) {
        return null;
    }
}
