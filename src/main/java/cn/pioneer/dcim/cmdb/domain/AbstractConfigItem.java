package cn.pioneer.dcim.cmdb.domain;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.domain.relationship.OwnedRelation;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.neo4j.ogm.annotation.GraphId;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.Relationship;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
//import org.springframework.data.neo4j.annotation.Indexed;

/**
 * 配置项虚拟基类，包括：id、名称、类型和创建更新信息
 *
 * @author luxinglin
 * @since 2018-01-09
 */
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public abstract class AbstractConfigItem {
    /**
     * 数据库主键ID
     */
    @GraphId
    private Long id;
    /**
     * 配置项名称
     */
//    @Indexed(unique = false,indexType = IndexType.FULLTEXT, indexName = "wordName")
    @Index
    private String name;
    /**
     * 配置项类型编码
     */
    @Index
    private String typeCode;
    /**
     * 配置项类型名称
     */
    private String typeName;
    /**
     * 责任人关系
     */
    @Relationship(type = CiRelationConst.OWNED)
    private Set<OwnedRelation> ownedRelationSet = new HashSet<>();
    /**
     * 来源
     */
    private String dataSource;
    /**
     * 创建时间
     */
    private Date createdDt;
    /**
     * 创建人
     */
    private String createdBy;
    /**
     * 更新时间
     */
    private Date updatedDt;
    /**
     * 更新人
     */
    private String updateBy;
    /**
     * 版本号
     */
    private int version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getDataSource() {
        return dataSource;
    }

    public void setDataSource(String dataSource) {
        this.dataSource = dataSource;
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public String getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(String updateBy) {
        this.updateBy = updateBy;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) {
            return true;
        }
        if (!(o instanceof AbstractConfigItem)) {
            return false;
        }

        AbstractConfigItem that = (AbstractConfigItem) o;

        return id != null ? id.equals(that.id) : that.id == null;
    }

    @Override
    public int hashCode() {
        return id != null ? id.hashCode() : 0;
    }

    public Set<OwnedRelation> getOwnedRelationSet() {
        return ownedRelationSet;
    }

    public void setOwnedRelationSet(Set<OwnedRelation> ownedRelationSet) {
        this.ownedRelationSet = ownedRelationSet;
    }
}
