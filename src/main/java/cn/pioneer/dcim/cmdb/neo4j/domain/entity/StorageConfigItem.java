package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.StorageLinkRelation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luxinglin
 * @Description 存储配置项
 * @since 2018-01-19
 */
@NodeEntity
public class StorageConfigItem extends AbstractConfigItem {
    /**
     * 序列号
     */
    private String sn;
    /**
     * 存储别名
     */
    private String aliasName;
    /**
     * 设备类型
     */
    private String storageType;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 型号
     */
    private String model;
    /**
     * 运行状态
     */
    private String runStatus;
    /**
     * 所在位置
     */
    private String locationDesc;
    /**
     * 用途
     */
    private String usePurpose;
    /**
     * 传输速率
     */
    private String transmissionSpeed;
    /**
     * RAID支持
     */
    private String raidSupport;
    /**
     * 容量
     */
    private String totalVolume;
    /**
     * 其他参数
     */
    private String otherParam;
    /**
     * 存储连接关系
     */
    @Relationship(type = CiRelationConst.STORAGE_LINK)
    private Set<StorageLinkRelation> serverSet = new HashSet<>();
    @Transient
    private String ownerIdStr;

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getAliasName() {
        return aliasName;
    }

    public void setAliasName(String aliasName) {
        this.aliasName = aliasName;
    }

    public String getStorageType() {
        return storageType;
    }

    public void setStorageType(String storageType) {
        this.storageType = storageType;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getRunStatus() {
        return runStatus;
    }

    public void setRunStatus(String runStatus) {
        this.runStatus = runStatus;
    }

    public String getLocationDesc() {
        return locationDesc;
    }

    public void setLocationDesc(String locationDesc) {
        this.locationDesc = locationDesc;
    }

    public String getUsePurpose() {
        return usePurpose;
    }

    public void setUsePurpose(String usePurpose) {
        this.usePurpose = usePurpose;
    }

    public String getTransmissionSpeed() {
        return transmissionSpeed;
    }

    public void setTransmissionSpeed(String transmissionSpeed) {
        this.transmissionSpeed = transmissionSpeed;
    }

    public String getRaidSupport() {
        return raidSupport;
    }

    public void setRaidSupport(String raidSupport) {
        this.raidSupport = raidSupport;
    }

    public String getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(String totalVolume) {
        this.totalVolume = totalVolume;
    }

    public String getOtherParam() {
        return otherParam;
    }

    public void setOtherParam(String otherParam) {
        this.otherParam = otherParam;
    }

    public Set<StorageLinkRelation> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<StorageLinkRelation> serverSet) {
        this.serverSet = serverSet;
    }

    public String getOwnerIdStr() {
        return ownerIdStr;
    }

    public void setOwnerIdStr(String ownerIdStr) {
        this.ownerIdStr = ownerIdStr;
    }
}
