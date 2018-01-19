package cn.pioneer.dcim.cmdb.common.graph;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 连接线
 * @create 2018-01-19 11:15
 **/
public class GraphLink {
    private int source;
    private int target;
    private String relation;

    public GraphLink() {
    }

    public GraphLink(int source, int target) {
        this.source = source;
        this.target = target;
    }

    public int getSource() {
        return source;
    }

    public void setSource(int source) {
        this.source = source;
    }

    public int getTarget() {
        return target;
    }

    public void setTarget(int target) {
        this.target = target;
    }

    public String getRelation() {
        return relation;
    }

    public void setRelation(String relation) {
        this.relation = relation;
    }
}
