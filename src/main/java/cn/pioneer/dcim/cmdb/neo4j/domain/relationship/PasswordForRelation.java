package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PasswordConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
@RelationshipEntity(type = CiRelationConst.PASSWORD_FOR)
public class PasswordForRelation extends AbstractRelationShip {
    @StartNode
    private PasswordConfigItem passwordConfigItem;

    @EndNode
    private AbstractConfigItem abstractConfigItem;

    public PasswordConfigItem getPasswordConfigItem() {
        return passwordConfigItem;
    }

    public void setPasswordConfigItem(PasswordConfigItem passwordConfigItem) {
        this.passwordConfigItem = passwordConfigItem;
    }

    public AbstractConfigItem getAbstractConfigItem() {
        return abstractConfigItem;
    }

    public void setAbstractConfigItem(AbstractConfigItem abstractConfigItem) {
        this.abstractConfigItem = abstractConfigItem;
    }
}
