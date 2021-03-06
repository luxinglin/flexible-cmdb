package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PersonConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@RelationshipEntity(type = CiRelationConst.OWNED)
public class OwnedRelation extends AbstractRelationShip {
    @StartNode
    private AbstractConfigItem abstractEntity;
    @EndNode
    private PersonConfigItem person;

    private String remark;

    public PersonConfigItem getPerson() {
        return person;
    }

    public void setPerson(PersonConfigItem person) {
        this.person = person;
    }

    public AbstractConfigItem getAbstractEntity() {
        return abstractEntity;
    }

    public void setAbstractEntity(AbstractConfigItem abstractEntity) {
        this.abstractEntity = abstractEntity;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
