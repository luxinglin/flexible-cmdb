package cn.pioneer.dcim.cmdb.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConstant;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.BelongToRelation;
import cn.pioneer.dcim.cmdb.domain.relationship.DeployOnRelation;
import org.neo4j.ogm.annotation.Index;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

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
     * 归属于xx人管理
     */
    @Relationship(type = CiRelationConstant.BELONG_TO)
    private Set<BelongToRelation> personSet;
    /**
     * 部署在xx服务器上
     */
    @Relationship(type = CiRelationConstant.DEPLOY_ON)
    private Set<DeployOnRelation> serverSet;

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

    public Set<BelongToRelation> getPersonSet() {
        return personSet;
    }

    public void setPersonSet(Set<BelongToRelation> personSet) {
        this.personSet = personSet;
    }

    public Set<DeployOnRelation> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<DeployOnRelation> serverSet) {
        this.serverSet = serverSet;
    }
}
