package cn.pioneer.dcim.cmdb.common.emun;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
public enum ServerTypeEnum {
    VIRTUAL_MACHINE("虚拟机", 1), PHYSICAL_MACHINE("物理机", 2);

    private String name;
    private int index;

    ServerTypeEnum(String name, int index) {
        this.name = name;
        this.index = index;
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
