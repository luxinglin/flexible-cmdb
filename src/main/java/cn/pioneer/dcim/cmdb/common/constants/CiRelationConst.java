package cn.pioneer.dcim.cmdb.common.constants;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: CMDB配置项关系常量
 * @create 2018-01-19 11:20
 */
public interface CiRelationConst {
    /**
     * 责任人关系，人员-其他配置项
     */
    String OWNED = "OWNED";
    /**
     * 部署关系，业务系统-服务器
     */
    String DEPLOY_ON = "DEPLOY_ON";
    /**
     * 密码归属关系，密码-其他配置项
     */
    String PASSWORD_FOR = "PASSWORD_FOR";
    /**
     * 虚拟化关系，物理机-虚拟机
     */
    String VIRTUAL_ON = "VIRTUAL_ON";
    /**
     * 中间件运行关系，中间件-服务器
     */
    String MIDDLEWARE_RUN_ON = "MIDDLEWARE_RUN_ON";
    /**
     * 网络连接关系，网络设备-其他设备【网络设备、服务器】
     */
    String NETWORK_LINK = "NETWORK_LINK";
    /**
     * 存储连接关系，存储设备-服务器
     */
    String STORAGE_LINK = "STORAGE_LINK";
}
