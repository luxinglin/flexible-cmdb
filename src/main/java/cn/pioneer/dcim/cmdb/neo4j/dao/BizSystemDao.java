package cn.pioneer.dcim.cmdb.neo4j.dao;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.BizSystemConfigItem;

import java.util.List;

/**
 * @author luxinglin
 * @since 2018-01-10
 */
public interface BizSystemDao {
    List<BizSystemConfigItem> queryBizSystemConfigItemByPerproty(BizSystemConfigItem bdApp);
}
