package cn.pioneer.dcim.cmdb.neo4j.domain.entity;

import cn.pioneer.dcim.cmdb.common.constants.CiRelationConst;
import cn.pioneer.dcim.cmdb.neo4j.domain.AbstractConfigItem;
import cn.pioneer.dcim.cmdb.neo4j.domain.relationship.MiddlewareRunOnRelation;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;
import org.neo4j.ogm.annotation.Transient;

import java.util.HashSet;
import java.util.Set;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 中间件配置对象
 * @create 2018-01-11 17:00
 **/
@NodeEntity
public class MiddlewareConfigItem extends AbstractConfigItem {
    /**
     * 中间件类型
     */
    private String middlewareType;
    /**
     * 用途
     */
    private String usePurpose;
    /**
     * 配置文件路径
     */
    private String configFilePath;
    /**
     * 日志文件路径
     */
    private String logFilePath;
    /**
     * 配置参数描述
     */
    private String configParamDesc;
    /**
     * 运行于特定服务器
     */
    @Relationship(type = CiRelationConst.MIDDLEWARE_RUN_ON)
    private Set<MiddlewareRunOnRelation> serverSet = new HashSet<>();
    /**
     *
     */
    @Transient
    private String serverIdStr;

    public String getMiddlewareType() {
        return middlewareType;
    }

    public void setMiddlewareType(String middlewareType) {
        this.middlewareType = middlewareType;
    }

    public String getUsePurpose() {
        return usePurpose;
    }

    public void setUsePurpose(String usePurpose) {
        this.usePurpose = usePurpose;
    }

    public String getConfigFilePath() {
        return configFilePath;
    }

    public void setConfigFilePath(String configFilePath) {
        this.configFilePath = configFilePath;
    }

    public String getLogFilePath() {
        return logFilePath;
    }

    public void setLogFilePath(String logFilePath) {
        this.logFilePath = logFilePath;
    }

    public String getConfigParamDesc() {
        return configParamDesc;
    }

    public void setConfigParamDesc(String configParamDesc) {
        this.configParamDesc = configParamDesc;
    }

    public Set<MiddlewareRunOnRelation> getServerSet() {
        return serverSet;
    }

    public void setServerSet(Set<MiddlewareRunOnRelation> serverSet) {
        this.serverSet = serverSet;
    }

    public String getServerIdStr() {
        return serverIdStr;
    }

    public void setServerIdStr(String serverIdStr) {
        this.serverIdStr = serverIdStr;
    }
}
