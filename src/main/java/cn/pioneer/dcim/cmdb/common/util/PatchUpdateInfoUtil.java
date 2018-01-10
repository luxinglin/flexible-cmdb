package cn.pioneer.dcim.cmdb.common.util;

import cn.pioneer.dcim.cmdb.domain.AbstractConfigItem;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;

public class PatchUpdateInfoUtil {
    private PatchUpdateInfoUtil() {
    }

    /**
     * patch基本的更新信息
     *
     * @param abstractEntity     配置项
     * @param httpServletRequest 请求头
     */
    public static void patch(AbstractConfigItem abstractEntity, HttpServletRequest httpServletRequest) {
        Date now = new Date();
        abstractEntity.setCreatedBy("luxinglin");
        abstractEntity.setUpdateBy("luxinglin");
        abstractEntity.setCreatedDt(now);
        abstractEntity.setUpdatedDt(now);
        abstractEntity.setDataSource("人工更新");
    }
}
