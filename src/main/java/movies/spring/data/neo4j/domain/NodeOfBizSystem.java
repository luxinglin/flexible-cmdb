package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import movies.spring.data.neo4j.common.constants.CiRelationConstant;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Set;

/**
 * 业务系统类
 *
 * @author luxinglin
 * @since 2018-01-08
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class NodeOfBizSystem extends AbstractEntity {
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 系统描述
     */
    private String bizSystemDesc;
    /**
     * 归属于xx人管理
     */
    @Relationship(type = CiRelationConstant.BELONG_TO)
    private Set<RelationOfBelongTo> personSet;
    /**
     * 部署在xx服务器上
     */
    @Relationship(type = CiRelationConstant.DEPLOY_ON)
    private Set<RelationOfDeployOn> serverSet;

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

    public Set<RelationOfBelongTo> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<RelationOfBelongTo> personSet) {
        this.personSet = personSet;
    }

    public Set<RelationOfDeployOn> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<RelationOfDeployOn> serverSet) {
        this.serverSet = serverSet;
    }
}
