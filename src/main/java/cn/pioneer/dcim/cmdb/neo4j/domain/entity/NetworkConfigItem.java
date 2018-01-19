package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
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
public class NetworkConfigItem extends AbstractConfigItem {
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
     * 网络设备间连接
     */
    @Relationship(type = "NETWORK_LINK")
    private List<NetworkConfigItem> networks = new ArrayList<>();

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

    public List<NetworkConfigItem> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NetworkConfigItem> networks) {
        this.networks = networks;
    }

}
