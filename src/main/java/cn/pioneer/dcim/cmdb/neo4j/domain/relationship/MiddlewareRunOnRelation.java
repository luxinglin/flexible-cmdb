package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:27
 **/
@RelationshipEntity(type = CiRelationConst.MIDDLEWARE_RUN_ON)
public class MiddlewareRunOnRelation extends AbstractRelationShip {
    @StartNode
    private MiddlewareConfigItem middleware;

    @EndNode
    private ServerConfigItem server;

    public MiddlewareConfigItem getMiddleware() {
        return middleware;
    }

    public void setMiddleware(MiddlewareConfigItem middleware) {
        this.middleware = middleware;
    }

    public ServerConfigItem getServer() {
        return server;
    }

    public void setServer(ServerConfigItem server) {
        this.server = server;
    }
}
