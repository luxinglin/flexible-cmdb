package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.Networkable;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.NetworkLinkRelation;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * 网络设备配置项
 *
 * @author luxinglin
 * @since 2018-01-10
 */

@NodeEntity
public class NetworkConfigItem extends AbstractConfigItem implements Networkable {
    /**
     * 序列号
     */
    private String sn;
    /**
     * 设备类型，支持交换机和路由器
     */
    private String networkType;
    /**
     * 品牌
     */
    @Index
    private String brand;
    /**
     * 型号
     */
    private String model;
    /**
     * 管理IP
     */
    private String manageIp;
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
     * 端口数
     */
    private Integer portNum;
    /**
     * 传输速率
     */
    private String transmissionSpeed;
    /**
     * 传输模式
     */
    private String transmissionMode;
    /**
     * 网络设备连接
     */
    @Relationship(type = CiRelationConst.NETWORK_LINK)
    private List<NetworkLinkRelation> networks = new ArrayList<>();

    public String getSn() {
        return sn;
    }

    public void setSn(String sn) {
        this.sn = sn;
    }

    public String getNetworkType() {
        return networkType;
    }

    public void setNetworkType(String networkType) {
        this.networkType = networkType;
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

    public String getManageIp() {
        return manageIp;
    }

    public void setManageIp(String manageIp) {
        this.manageIp = manageIp;
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

    public Integer getPortNum() {
        return portNum;
    }

    public void setPortNum(Integer portNum) {
        this.portNum = portNum;
    }

    public String getTransmissionSpeed() {
        return transmissionSpeed;
    }

    public void setTransmissionSpeed(String transmissionSpeed) {
        this.transmissionSpeed = transmissionSpeed;
    }

    public String getTransmissionMode() {
        return transmissionMode;
    }

    public void setTransmissionMode(String transmissionMode) {
        this.transmissionMode = transmissionMode;
    }

    public List<NetworkLinkRelation> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkLinkRelation> networks) {
        this.networks = networks;
    }
}
