package movies.spring.data.neo4j.common.util;

import movies.spring.data.neo4j.domain.AbstractEntity;

import java.util.Date;

public class PatchUpdateInfoUtil {
    private PatchUpdateInfoUtil() {
    }

    public static void patch(AbstractEntity abstractEntity) {
        Date now = new Date();
        abstractEntity.setCreatedBy("luxinglin");
        abstractEntity.setUpdateBy("luxinglin");
        abstractEntity.setCreatedDt(now);
        abstractEntity.setUpdatedDt(now);
        abstractEntity.setDataSource("人工更新");
    }
}
