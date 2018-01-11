package cn.pioneer.dcim.cmdb.common.util;

import org.neo4j.ogm.model.Result;
import org.neo4j.ogm.session.Session;

import java.util.Iterator;
import java.util.Map;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: neo4j数据访问工具类
 * @create 2018-01-11 10:15
 **/
public class Neo4jDaoUtil {
    private Neo4jDaoUtil() {
    }

    /**
     * @param session
     * @param cypher
     * @param params
     * @return
     */
    public static int getTotalNum(Session session, String cypher, Map<String, String> params) {
        Result result = session.query(cypher, params);
        int totalNum = 0;
        if (result == null) {
            return totalNum;
        }
        Iterator<Map<String, Object>> its = result.iterator();
        while (its.hasNext()) {
            Map<String, Object> ret = its.next();
            if (ret != null) {
                Object nums = ret.getOrDefault("count", 0);
                if (nums != null) {
                    totalNum = Integer.parseInt(nums.toString());
                    break;
                }
            }
        }
        return totalNum;
    }

    /**
     * @param condition
     * @return
     */
    public static String appendLike(String condition) {
        if (condition == null || condition.isEmpty()) {
            return "";
        }
        return ".*".concat(condition.trim()).concat("*.");
    }
}
