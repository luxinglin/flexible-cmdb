package cn.pioneer.dcim.cmdb.sync.common;

import cn.pioneer.dcim.cmdb.domain.entity.PersonConfigItem;
import cn.pioneer.dcim.cmdb.model.SysUser;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-18 17:26
 **/
public class CompareUtil {
    private CompareUtil() {
    }

    public static boolean equals(SysUser sysUser, PersonConfigItem personConfigItem) {
        if (sysUser == null || sysUser.getUserSid() == null) {
            return false;
        }
        if (personConfigItem == null || personConfigItem.getUserSid() == null) {
            return false;
        }
        return sysUser.getUserSid().equals(personConfigItem.getUserSid());
    }
}
