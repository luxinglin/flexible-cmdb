package movies.spring.data.neo4j.domain;

import movies.spring.data.neo4j.common.constants.CiRelationConstant;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@RelationshipEntity(type= CiRelationConstant.DEPLOY_ON)
public class RelationOfDeployOn extends AbstractEntity{
    @StartNode
    private NodeOfBizSystem bizSystem;

    @EndNode
    private NodeOfServer server;

    public NodeOfBizSystem getBizSystem() {
        return bizSystem;
    }

    public void setBizSystem(NodeOfBizSystem bizSystem) {
        this.bizSystem = bizSystem;
    }

    public NodeOfServer getServer() {
        return server;
    }

    public void setServer(NodeOfServer server) {
        this.server = server;
    }
}
