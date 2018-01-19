package cn.pioneer.dcim.cmdb.neo4j.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.StorageConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:29
 **/
@RelationshipEntity(type = CiRelationConst.STORAGE_LINK)
public class StorageLinkRelation extends AbstractRelationShip {
    @StartNode
    StorageConfigItem storage;

    @EndNode
    ServerConfigItem server;

    public StorageConfigItem getStorage() {
        return storage;
    }

    public void setStorage(StorageConfigItem storage) {
        this.storage = storage;
    }

    public ServerConfigItem getServer() {
        return server;
    }

    public void setServer(ServerConfigItem server) {
        this.server = server;
    }
}
