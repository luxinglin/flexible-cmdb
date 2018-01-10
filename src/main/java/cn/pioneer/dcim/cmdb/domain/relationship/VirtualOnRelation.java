package cn.pioneer.dcim.cmdb.domain.relationship;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractRelationShip;
import cn.pioneer.dcim.cmdb.domain.entity.ServerConfigItem;
import org.neo4j.ogm.annotation.EndNode;
import org.neo4j.ogm.annotation.RelationshipEntity;
import org.neo4j.ogm.annotation.StartNode;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
@RelationshipEntity(type = CiRelationConstant.VIRTUAL_ON)
public class VirtualOnRelation extends AbstractRelationShip {
    /**
     * 虚拟机
     */
    @StartNode
    private ServerConfigItem virtalMachine;
    /**
     * 物理机
     */
    @EndNode
    private ServerConfigItem physicalMachine;

    private String storageLun;

    public ServerConfigItem getVirtalMachine() {
        return virtalMachine;
    }

    public void setVirtalMachine(ServerConfigItem virtalMachine) {
        this.virtalMachine = virtalMachine;
    }

    public ServerConfigItem getPhysicalMachine() {
        return physicalMachine;
    }

    public void setPhysicalMachine(ServerConfigItem physicalMachine) {
        this.physicalMachine = physicalMachine;
    }

    public String getStorageLun() {
        return storageLun;
    }

    public void setStorageLun(String storageLun) {
        this.storageLun = storageLun;
    }
}
