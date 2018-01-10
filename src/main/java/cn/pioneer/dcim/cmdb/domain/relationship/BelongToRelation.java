package cn.pioneer.dcim.cmdb.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.domain.entity.Person;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * 应用系统<->人员的归属关系，描述应用系统下各个职责角色的归属人
 *
 * @author luxinglin
 * @since 2018-01-09
 */
@RelationshipEntity(type = CiRelationConstant.BELONG_TO)
public class BelongToRelation extends AbstractRelationShip {
    /**
     * 业务系统
     */
    @StartNode
    private BizSystemConfigItem bizSystem;
    /**
     * 人员
     */
    @EndNode
    private Person person;
    /**
     * 管理角色
     */
    private String roleName;

    public BizSystemConfigItem getBizSystem() {
        return bizSystem;
    }

    public void setBizSystem(BizSystemConfigItem bizSystem) {
        this.bizSystem = bizSystem;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
