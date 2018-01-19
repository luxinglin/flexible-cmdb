package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.Networkable;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.NetworkConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:29
 **/
@RelationshipEntity(type = CiRelationConst.NETWORK_LINK)
public class NetworkLinkRelation extends AbstractRelationShip {
    @StartNode
    NetworkConfigItem network;

    @EndNode
    Networkable linkTarget;

    public NetworkConfigItem getNetwork() {
        return network;
    }

    public void setNetwork(NetworkConfigItem network) {
        this.network = network;
    }

    public Networkable getLinkTarget() {
        return linkTarget;
    }

    public void setLinkTarget(Networkable linkTarget) {
        this.linkTarget = linkTarget;
    }
}
