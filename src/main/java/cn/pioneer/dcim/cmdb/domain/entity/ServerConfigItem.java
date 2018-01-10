package cn.pioneer.dcim.cmdb.domain.entity;

import cn.pioneer.dcim.cmdb.common.ServerTypeEnum;
import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.VirtualOnRelation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@NodeEntity
public class ServerConfigItem extends AbstractConfigItem {
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
    @Relationship(type = CiRelationConstant.VIRTUAL_ON)
    private Set<VirtualOnRelation> serverSet;
    /**
     * 服务器-网络交换机连接关系
     */
    @Relationship(type = "SERVER_NETWORK_LINK", direction = Relationship.INCOMING)
    private List<NetworkConfigItem> networks = new ArrayList<>();

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

    public List<NetworkConfigItem> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkConfigItem> networks) {
        this.networks = networks;
    }
}
