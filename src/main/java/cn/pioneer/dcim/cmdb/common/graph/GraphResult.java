package cn.pioneer.dcim.cmdb.common.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 图形数据集合
 * @create 2018-01-19 11:10
 **/
public class GraphResult {
    List<GraphNode> nodes = new ArrayList<>();
    List<GraphLink> links = new ArrayList<>();

    public List<GraphNode> getNodes() {
        return nodes;
    }

    public void setNodes(List<GraphNode> nodes) {
        this.nodes = nodes;
    }

    public List<GraphLink> getLinks() {
        return links;
    }

    public void setLinks(List<GraphLink> links) {
        this.links = links;
    }
}
