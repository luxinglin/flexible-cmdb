package cn.pioneer.dcim.cmdb.common.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author luxinglin
 * @since 2018-01-08
 */
public class ToyUtil {

    private ToyUtil() {
    }

    public static Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }

    /**
     * 是否是大于0的id值
     *
     * @param id id值
     * @return
     */
    public static boolean validID(Object id) {
        if (id == null) {
            return false;
        }
        if (id instanceof Long) {
            return ((Long) id).longValue() > 0;
        }
        if (id instanceof Integer) {
            return ((Integer) id).intValue() > 0;
        }
        return false;
    }

    public static boolean isSpecifyType(Class cls, String type) {
        return cls.getSimpleName().equals(type);
    }

}
