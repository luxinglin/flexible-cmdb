package movies.spring.data.neo4j.common;

import java.util.HashMap;
import java.util.Map;

public class ToyUtil {
    private ToyUtil(){}
    public static Map<String, Object> map(String key1, Object value1, String key2, Object value2) {
        Map<String, Object> result = new HashMap<String, Object>(2);
        result.put(key1, value1);
        result.put(key2, value2);
        return result;
    }
}
