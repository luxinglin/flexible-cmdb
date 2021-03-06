package cn.pioneer.dcim.cmdb.common.emun;

/**
 * 服务器类型
 * @author luxinglin
 * @since 2018-01-10
 */
public enum ServerTypeEnum {
    VIRTUAL_MACHINE("VIRTUAL_MACHINE", "虚拟机", 1), PHYSICAL_MACHINE("PHYSICAL_MACHINE", "物理机", 2);
    private String code;
    private String name;
    private int index;

    ServerTypeEnum(String code, String name, int index) {
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
