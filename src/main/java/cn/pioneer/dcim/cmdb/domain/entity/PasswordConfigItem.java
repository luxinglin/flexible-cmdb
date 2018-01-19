package cn.pioneer.dcim.cmdb.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.domain.relationship.PasswordForRelation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

/**
 * 密码配置项
 *
 * @author luxinglin
 * @since 2018-01-10
 */
@NodeEntity
public class PasswordConfigItem extends AbstractConfigItem {
    /**
     * 用户名
     */
    private String userName;
    /**
     * 密码
     */
    private String password;
    /**
     * 备注
     */
    private String remark;
    /**
     * 属于某一个配置项
     */
    @Relationship(type = CiRelationConst.PASSWORD_FOR)
    private Set<PasswordForRelation> passwordForRelations = new HashSet<>();

    @Transient
    private String bizSystemIdStr;
    @Transient
    private String serverIdStr;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Set<PasswordForRelation> getPasswordForRelations() {
        return passwordForRelations;
    }

    public void setPasswordForRelations(Set<PasswordForRelation> passwordForRelations) {
        this.passwordForRelations = passwordForRelations;
    }

    public String getBizSystemIdStr() {
        return bizSystemIdStr;
    }

    public void setBizSystemIdStr(String bizSystemIdStr) {
        this.bizSystemIdStr = bizSystemIdStr;
    }

    public String getServerIdStr() {
        return serverIdStr;
    }

    public void setServerIdStr(String serverIdStr) {
        this.serverIdStr = serverIdStr;
    }
}
