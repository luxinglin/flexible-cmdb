package cn.pioneer.dcim.cmdb.dao;

import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;

import java.util.List;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
public interface BizSystemDao {
    List<BizSystemConfigItem> queryBizSystemConfigItemByPerproty(BizSystemConfigItem bdApp);
}
