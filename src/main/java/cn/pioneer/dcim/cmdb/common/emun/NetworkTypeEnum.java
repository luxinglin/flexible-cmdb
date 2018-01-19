package cn.pioneer.dcim.cmdb.common.emun;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 网络设备类型
 * @create 2018-01-19 16:29
 **/
public enum NetworkTypeEnum {
    SWITCH("SWITCH", "交换机", 1), ROUTER("ROUTER", "路由器", 2);

    private String code;
    private String name;
    private int index;

    NetworkTypeEnum(String code, String name, int index) {
        this.code = code;
        this.name = name;
        this.index = index;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
