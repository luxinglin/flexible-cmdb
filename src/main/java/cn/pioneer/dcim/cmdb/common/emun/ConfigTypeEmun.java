package cn.pioneer.dcim.cmdb.common.emun;

import cn.pioneer.dcim.cmdb.domain.entity.*;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 16:18
 **/
public enum ConfigTypeEmun {
    /**
     * 配置项类型集合
     */
    BIZSYSTEM("业务系统", BizSystemConfigItem.class.getSimpleName(), 1),
    SERVER("服务器", ServerConfigItem.class.getSimpleName(), 2),
    NETWORK("网络设备", NetworkConfigItem.class.getSimpleName(), 3),
    STORAGE("存储设备", StorageConfigItem.class.getSimpleName(), 4),
    MIDDLEWARE("中间件", MiddlewareConfigItem.class.getSimpleName(), 5),
    PASSWORD("密码", PasswordConfigItem.class.getSimpleName(), 6),
    PERSON("人员", PersonConfigItem.class.getSimpleName(), 7);
    //属性集合
    /**
     * 名称
     */
    private String name;
    /**
     * 编码
     */
    private String code;
    /**
     * 下标
     */
    private int index;

    ConfigTypeEmun(String name, String code, int index) {
        this.name = name;
        this.code = code;
        this.index = index;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
