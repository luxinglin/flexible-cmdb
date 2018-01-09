package movies.spring.data.neo4j.domain;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@NodeEntity
public class NodeOfServer extends AbstractEntity {

    /*UUID	设备名称	序列号	品牌	型号
    UUID	NAME	SN	BRAND	MODEL*/
    private String uuid;
    private String name;
    private String sn;
    private String brand;
    private String model;

    @Relationship(type = "SERVER_NETWORK_LINK", direction = Relationship.INCOMING)
    private List<NodeOfNetwork> networks = new ArrayList<>();


    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

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

    public List<NodeOfNetwork> getNetworks() {
        return networks;
    }

    public void setNetworks(List<NodeOfNetwork> networks) {
        this.networks = networks;
    }
}
