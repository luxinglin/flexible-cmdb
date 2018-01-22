package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.common.emun.ServerTypeEnum;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.Networkable;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.MiddlewareRunOnRelation;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.NetworkLinkRelation;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.StorageLinkRelation;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.VirtualOnRelation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@NodeEntity
public class ServerConfigItem extends AbstractConfigItem implements Networkable {
    /**
     * UUID
     */
    private String uuid;
    /**
     * 序列号
     */
    private String sn;
    /**
     * 品牌
     */
    private String brand;
    /**
     * 型号
     */
    private String model;

    /**
     * 服务器类型 物理机、虚拟机
     */
    private ServerTypeEnum serverTypeEnum;
    /**
     * 管理IP
     */
    private String manageIP;
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
     * OS类型
     */
    private String osFamily;
    /**
     * OS版本
     */
    private String osVersion;
    /**
     * CPU数量
     */
    private Integer cpuNum;
    /**
     * 内存大小
     */
    private String memory;
    /**
     * 磁盘数量
     */
    private Integer diskNum;
    /**
     * 容量
     */
    private String diskInitSize;
    /**
     * 网卡型号
     */
    private String networkCardModel;
    /**
     * 网卡数量
     */
    private Integer networkCardNum;
    /**
     * 物理机-虚拟机关系
     */
    @Relationship(type = CiRelationConst.VIRTUAL_ON)
    private Set<VirtualOnRelation> serverSet = new HashSet<>();
    /**
     * 服务器-网络交换机连接关系
     */
    @Relationship(type = CiRelationConst.NETWORK_LINK)
    private Set<NetworkLinkRelation> networks = new HashSet<>();
    /**
     * 服务器-存储连接关系
     */
    @Relationship(type = CiRelationConst.STORAGE_LINK)
    private Set<StorageLinkRelation> storages = new HashSet<>();
    /**
     * 服务器-中间件运行关系
     */
    @Relationship(type = CiRelationConst.MIDDLEWARE_RUN_ON)
    private Set<MiddlewareRunOnRelation> middlewares = new HashSet<>();
    @Transient
    private String ownerIdStr;
    @Transient
    private String networkIdStr;
    @Transient
    private String storageIdStr;
    @Transient
    private String bizSystemIdStr;
    @Transient
    private Long belongPhysicalServerId;

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
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

    public ServerTypeEnum getServerTypeEnum() {
        return serverTypeEnum;
    }

    public void setServerTypeEnum(ServerTypeEnum serverTypeEnum) {
        this.serverTypeEnum = serverTypeEnum;
    }

    public String getManageIP() {
        return manageIP;
    }

    public void setManageIP(String manageIP) {
        this.manageIP = manageIP;
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

    public String getOsFamily() {
        return osFamily;
    }

    public void setOsFamily(String osFamily) {
        this.osFamily = osFamily;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public Integer getCpuNum() {
        return cpuNum;
    }

    public void setCpuNum(Integer cpuNum) {
        this.cpuNum = cpuNum;
    }

    public String getMemory() {
        return memory;
    }

    public void setMemory(String memory) {
        this.memory = memory;
    }

    public Integer getDiskNum() {
        return diskNum;
    }

    public void setDiskNum(Integer diskNum) {
        this.diskNum = diskNum;
    }

    public String getDiskInitSize() {
        return diskInitSize;
    }

    public void setDiskInitSize(String diskInitSize) {
        this.diskInitSize = diskInitSize;
    }

    public String getNetworkCardModel() {
        return networkCardModel;
    }

    public void setNetworkCardModel(String networkCardModel) {
        this.networkCardModel = networkCardModel;
    }

    public Integer getNetworkCardNum() {
        return networkCardNum;
    }

    public void setNetworkCardNum(Integer networkCardNum) {
        this.networkCardNum = networkCardNum;
    }

    public Set<VirtualOnRelation> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<VirtualOnRelation> serverSet) {
        this.serverSet = serverSet;
    }

    public Set<NetworkLinkRelation> getNetworks() {
        return networks;
    }

    public void setNetworks(Set<NetworkLinkRelation> networks) {
        this.networks = networks;
    }

    public Set<StorageLinkRelation> getStorages() {
        return storages;
    }

    public void setStorages(Set<StorageLinkRelation> storages) {
        this.storages = storages;
    }

    public String getOwnerIdStr() {
        return ownerIdStr;
    }

    public void setOwnerIdStr(String ownerIdStr) {
        this.ownerIdStr = ownerIdStr;
    }

    public String getNetworkIdStr() {
        return networkIdStr;
    }

    public void setNetworkIdStr(String networkIdStr) {
        this.networkIdStr = networkIdStr;
    }

    public String getStorageIdStr() {
        return storageIdStr;
    }

    public void setStorageIdStr(String storageIdStr) {
        this.storageIdStr = storageIdStr;
    }

    public String getBizSystemIdStr() {
        return bizSystemIdStr;
    }

    public void setBizSystemIdStr(String bizSystemIdStr) {
        this.bizSystemIdStr = bizSystemIdStr;
    }

    public Set<MiddlewareRunOnRelation> getMiddlewares() {
        return middlewares;
    }

    public void setMiddlewares(Set<MiddlewareRunOnRelation> middlewares) {
        this.middlewares = middlewares;
    }
}
