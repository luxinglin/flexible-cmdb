package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.PasswordForRelation;
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
    /**
     * 业务系统密码
     */
    @Transient
    private String bizSystemIdStr;
    /**
     * 服务器密码
     */
    @Transient
    private String serverIdStr;
    /**
     * 网络设备密码
     */
    @Transient
    private String networkIdStr;
    /**
     * 中间件密码
     */
    @Transient
    private String middlewareIdStr;
    /**
     * 存储设备密码
     */
    @Transient
    private String storageIdStr;

    @Transient
    private String configItemType;
    @Transient
    private Long configItemId;

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

    public String getNetworkIdStr() {
        return networkIdStr;
    }

    public void setNetworkIdStr(String networkIdStr) {
        this.networkIdStr = networkIdStr;
    }

    public String getMiddlewareIdStr() {
        return middlewareIdStr;
    }

    public void setMiddlewareIdStr(String middlewareIdStr) {
        this.middlewareIdStr = middlewareIdStr;
    }

    public String getStorageIdStr() {
        return storageIdStr;
    }

    public void setStorageIdStr(String storageIdStr) {
        this.storageIdStr = storageIdStr;
    }

    public String getConfigItemType() {
        return configItemType;
    }

    public void setConfigItemType(String configItemType) {
        this.configItemType = configItemType;
    }

    public Long getConfigItemId() {
        return configItemId;
    }

    public void setConfigItemId(Long configItemId) {
        this.configItemId = configItemId;
    }
}
