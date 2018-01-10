package cn.pioneer.dcim.cmdb.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.domain.entity.Person;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@RelationshipEntity(type = CiRelationConstant.OWNED)
public class OwnedRelation extends AbstractRelationShip {

    @StartNode
    private Person person;

    @EndNode
    private AbstractConfigItem abstractEntity;

    private String remark;

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
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
