package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import org.neo4j.ogm.annotation.NodeEntity;

/**
 * @author luxinglin
 * @Description 用户配置项，从集成系统进行同步
 * @since 2018-01-18
 */
@NodeEntity
public class PersonConfigItem extends AbstractConfigItem {

    private Long userSid;

    private String userType;

    private String account;

    private String password;

    private String password64;

    private String realName;

    private Integer sex;

    private String email;

    private String mobile;

    public PersonConfigItem() {
    }

    public PersonConfigItem(String name) {
        this.setName(name);
    }

    public Long getUserSid() {
        return userSid;
    }

    public void setUserSid(Long userSid) {
        this.userSid = userSid;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword64() {
        return password64;
    }

    public void setPassword64(String password64) {
        this.password64 = password64;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }
}
