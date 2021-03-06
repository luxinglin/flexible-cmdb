package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.BizSystemConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@RelationshipEntity(type = CiRelationConst.DEPLOY_ON)
public class DeployOnRelation extends AbstractRelationShip {
    @StartNode
    private BizSystemConfigItem bizSystem;

    @EndNode
    private ServerConfigItem server;

    public BizSystemConfigItem getBizSystem() {
        return bizSystem;
    }

    public void setBizSystem(BizSystemConfigItem bizSystem) {
        this.bizSystem = bizSystem;
    }

    public ServerConfigItem getServer() {
        return server;
    }

    public void setServer(ServerConfigItem server) {
        this.server = server;
    }
}
