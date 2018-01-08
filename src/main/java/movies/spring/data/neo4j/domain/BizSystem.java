package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * 业务系统类
 *
 * @author luxinglin
 * @since 2018-01-08
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class BizSystem {

    @GraphId
    private Long id;
    private String name;
    private String code;
    private String bizSystemDesc;
    @Relationship(type = "RELEATED_TO", direction = Relationship.INCOMING)
    private List<Person> personList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBizSystemDesc() {
        return bizSystemDesc;
    }

    public void setBizSystemDesc(String bizSystemDesc) {
        this.bizSystemDesc = bizSystemDesc;
    }

    public List<Person> getPersonList() {
        return personList;
    }

    public void setPersonList(List<Person> personList) {
        this.personList = personList;
    }
}
