package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class NodeOfNetwork extends AbstractEntity {
    //NAME	SN	NETWORK_TYPE	BRAND	MODEL	MANAGE_IP
    private String name;
    private String sn;
    private String networkType;
    private String brand;
    private String model;
    private String manageIp;

    /**
     * 网络设备间连接
     */
    @Relationship(type = "NETWORK_LINK")
    private List<NodeOfNetwork> networks = new ArrayList<>();

    @Relationship(type = "SERVER_NETWORK_LINK",direction = Relationship.INCOMING)
    private List<NodeOfServer> servers = new ArrayList<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

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

    public List<NodeOfNetwork> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NodeOfNetwork> networks) {
        this.networks = networks;
    }

    public List<NodeOfServer> getServers() {
        return servers;
    }

    public void setServers(List<NodeOfServer> servers) {
        this.servers = servers;
    }
}
