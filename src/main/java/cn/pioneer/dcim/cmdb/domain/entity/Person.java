package cn.pioneer.dcim.cmdb.domain.entity;

import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author Mark Angrish
 */
@NodeEntity
public class Person extends AbstractConfigItem {

    private int age;

    public Person() {
    }

    public Person(String name) {
        this.setName(name);
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
