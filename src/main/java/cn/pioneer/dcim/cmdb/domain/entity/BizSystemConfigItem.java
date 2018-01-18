package cn.pioneer.dcim.cmdb.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.DeployOnRelation;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

/**
 * 业务系统类配置项
 *
 * @author luxinglin
 * @since 2018-01-08
 */
@NodeEntity
public class BizSystemConfigItem extends AbstractConfigItem {
    /**
     * 编码
     */
    @Index
    private String code;
    /**
     * 系统描述
     */
    private String bizSystemDesc;
    /**
     * 部署在xx服务器上
     */
    @Relationship(type = CiRelationConstant.DEPLOY_ON)
    private Set<DeployOnRelation> serverSet = new HashSet<>();
    /**
     * 业务接口人
     */
    @Transient
    private String bizContactIdStr;
    /**
     * 业务关系人
     */
    @Transient
    private String bizRelationIdStr;
    @Transient
    private String serverIdStr;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getBizSystemDesc() {
        return bizSystemDesc;
    }

    public void setBizSystemDesc(String bizSystemDesc) {
        this.bizSystemDesc = bizSystemDesc;
    }

    public Set<DeployOnRelation> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<DeployOnRelation> serverSet) {
        this.serverSet = serverSet;
    }

    public String getBizContactIdStr() {
        return bizContactIdStr;
    }

    public void setBizContactIdStr(String bizContactIdStr) {
        this.bizContactIdStr = bizContactIdStr;
    }

    public String getBizRelationIdStr() {
        return bizRelationIdStr;
    }

    public void setBizRelationIdStr(String bizRelationIdStr) {
        this.bizRelationIdStr = bizRelationIdStr;
    }

    public String getServerIdStr() {
        return serverIdStr;
    }

    public void setServerIdStr(String serverIdStr) {
        this.serverIdStr = serverIdStr;
    }
}
