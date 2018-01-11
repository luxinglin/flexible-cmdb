package cn.pioneer.dcim.cmdb.common;

import java.util.Map;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-11 10:20
 **/
public interface Neo4jDao<T> {
    /**
     * 构造查询语句
     *
     * @param t
     * @param params
     * @return
     */
    String getListCypher(T t, Map<String, String> params);
}
