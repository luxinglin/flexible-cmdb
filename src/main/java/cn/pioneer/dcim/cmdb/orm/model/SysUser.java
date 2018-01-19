package cn.pioneer.dcim.cmdb.orm.model;

import java.util.Date;

public class SysUser {
    private Long userSid;

    private String userType;

    private String account;

    private String password;

    private String password64;

    private String realName;

    private Integer sex;

    private String email;

    private String mobile;

    private Long orgSid;

    private String depName;

    private String mgtObjSid;

    private Long bizSid;

    private String pmName;

    private String pmTel;

    private String pmEmail;

    private Long tenantSid;

    private String status;

    private String remark;

    private Integer errorCount;

    private Date lastLoginTime;

    private String lastLoginIp;

    private Integer serviceLimitQuantity;

    private String applyReason;

    private Integer smsMax;

    private String createdBy;

    private Date createdDt;

    private String updatedBy;

    private Date updatedDt;

    private Long version;

    private String uuid;

    private Long companyId;

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
        this.userType = userType == null ? null : userType.trim();
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getPassword64() {
        return password64;
    }

    public void setPassword64(String password64) {
        this.password64 = password64 == null ? null : password64.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
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
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public Long getOrgSid() {
        return orgSid;
    }

    public void setOrgSid(Long orgSid) {
        this.orgSid = orgSid;
    }

    public String getDepName() {
        return depName;
    }

    public void setDepName(String depName) {
        this.depName = depName == null ? null : depName.trim();
    }

    public String getMgtObjSid() {
        return mgtObjSid;
    }

    public void setMgtObjSid(String mgtObjSid) {
        this.mgtObjSid = mgtObjSid == null ? null : mgtObjSid.trim();
    }

    public Long getBizSid() {
        return bizSid;
    }

    public void setBizSid(Long bizSid) {
        this.bizSid = bizSid;
    }

    public String getPmName() {
        return pmName;
    }

    public void setPmName(String pmName) {
        this.pmName = pmName == null ? null : pmName.trim();
    }

    public String getPmTel() {
        return pmTel;
    }

    public void setPmTel(String pmTel) {
        this.pmTel = pmTel == null ? null : pmTel.trim();
    }

    public String getPmEmail() {
        return pmEmail;
    }

    public void setPmEmail(String pmEmail) {
        this.pmEmail = pmEmail == null ? null : pmEmail.trim();
    }

    public Long getTenantSid() {
        return tenantSid;
    }

    public void setTenantSid(Long tenantSid) {
        this.tenantSid = tenantSid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getErrorCount() {
        return errorCount;
    }

    public void setErrorCount(Integer errorCount) {
        this.errorCount = errorCount;
    }

    public Date getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(Date lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getLastLoginIp() {
        return lastLoginIp;
    }

    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp == null ? null : lastLoginIp.trim();
    }

    public Integer getServiceLimitQuantity() {
        return serviceLimitQuantity;
    }

    public void setServiceLimitQuantity(Integer serviceLimitQuantity) {
        this.serviceLimitQuantity = serviceLimitQuantity;
    }

    public String getApplyReason() {
        return applyReason;
    }

    public void setApplyReason(String applyReason) {
        this.applyReason = applyReason == null ? null : applyReason.trim();
    }

    public Integer getSmsMax() {
        return smsMax;
    }

    public void setSmsMax(Integer smsMax) {
        this.smsMax = smsMax;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy == null ? null : createdBy.trim();
    }

    public Date getCreatedDt() {
        return createdDt;
    }

    public void setCreatedDt(Date createdDt) {
        this.createdDt = createdDt;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy == null ? null : updatedBy.trim();
    }

    public Date getUpdatedDt() {
        return updatedDt;
    }

    public void setUpdatedDt(Date updatedDt) {
        this.updatedDt = updatedDt;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid == null ? null : uuid.trim();
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }
}