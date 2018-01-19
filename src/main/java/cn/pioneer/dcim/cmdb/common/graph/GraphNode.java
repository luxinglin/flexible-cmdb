package cn.pioneer.dcim.cmdb.common.graph;

import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 图形节点
 * @create 2018-01-19 11:11
 **/
public class GraphNode {
    /**
     * 对象ID
     */
    private Long id;
    /**
     * 名称
     */
    private String title;
    /**
     * 类型
     */
    private String typeCode;
    /**
     * 类型名称
     */
    private String typeName;
    /**
     * 图片
     */
    private String image;
    /**
     * tooltips
     */
    private String tips;
    /**
     * 原始的配置项
     */
    private AbstractConfigItem configItem;

    public GraphNode() {
    }

    public GraphNode(AbstractConfigItem configItem) {
        this.configItem = configItem;
        if (configItem != null) {
            this.id = configItem.getId();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof GraphNode)) {
            return false;
        }

        GraphNode graphNode = (GraphNode) o;

        return getId().equals(graphNode.getId());
    }

    @Override
    public int hashCode() {
        return getId().hashCode();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public AbstractConfigItem getConfigItem() {
        return configItem;
    }

    public void setConfigItem(AbstractConfigItem configItem) {
        this.configItem = configItem;
    }
}
