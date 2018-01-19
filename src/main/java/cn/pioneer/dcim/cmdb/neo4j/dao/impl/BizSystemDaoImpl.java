package cn.pioneer.dcim.cmdb.neo4j.dao.impl;

import cn.pioneer.dcim.cmdb.common.Neo4jDao;
import cn.pioneer.dcim.cmdb.neo4j.dao.BizSystemDao;
import cn.pioneer.dcim.cmdb.neo4j.domain.entity.BizSystemConfigItem;
import org.apache.commons.lang3.StringUtils;
import org.neo4j.ogm.session.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static cn.pioneer.dcim.cmdb.common.util.Neo4jDaoUtil.appendLike;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: 业务系统DAO实现类
 * @create 2018-01-10 10:15
 */
@Repository
public class BizSystemDaoImpl implements BizSystemDao, Neo4jDao<BizSystemConfigItem> {
    private static final String QUERY_PREFFIX = "MATCH (bizSystemConfigItem:BizSystemConfigItem) ";
    private static final String QUERY_WHERE = " WHERE  1 = 1 ";
    @Autowired
    Session session;

    @Override
    public List<BizSystemConfigItem> queryBizSystemConfigItemByPerproty(BizSystemConfigItem bizSystemConfigItem) {
        Map<String, String> params = new HashMap<>();
        String cypher = this.getListCypher(bizSystemConfigItem, params);
        if (StringUtils.isEmpty(cypher)) {
            return null;
        }
        Iterable<BizSystemConfigItem> its = session.query(BizSystemConfigItem.class, cypher, params);
        if (its == null) {
            return null;
        }
        List<BizSystemConfigItem> results = new ArrayList<>();
        its.forEach((v) -> results.add(v));
        return results;
    }

    @Override
    public String getListCypher(BizSystemConfigItem bizSystemConfigItem, Map<String, String> params) {
        StringBuffer stringBuffer = new StringBuffer(QUERY_PREFFIX);
        stringBuffer.append(QUERY_WHERE);
        //Condition构造
        stringBuffer.append(constructCypher(bizSystemConfigItem, params));
        //WITH n MATCH p=(n)-[*0..1]-(m) RETURN p, ID(n)
        stringBuffer.append(" WITH bizSystemConfigItem MATCH p=(bizSystemConfigItem)-[*0..1]-(m)  ");
        //Return构造
        stringBuffer.append(" RETURN p,ID(bizSystemConfigItem)");
        //Sort设置
        //stringBuffer.append(" ORDER BY bizSystemConfigItem.name,bizSystemConfigItem.code,bizSystemConfigItem.id ASC ");
        return stringBuffer.toString();
    }

    /**
     * @param domain
     * @param queryParams
     * @return
     */
    private String constructCypher(BizSystemConfigItem domain, Map<String, String> queryParams) {
        StringBuffer stringBuffer = new StringBuffer();
        if (!StringUtils.isEmpty(domain.getName())) {
            stringBuffer.append(" AND bizSystemConfigItem.name =~ {name}");
            queryParams.put("name", appendLike(domain.getName()));
        }
        if (!StringUtils.isEmpty(domain.getCode())) {
            stringBuffer.append(" AND bizSystemConfigItem.code = {code}");
            queryParams.put("code", domain.getCode());
        }
        if (!StringUtils.isEmpty(domain.getBizSystemDesc())) {
            stringBuffer.append(" AND bizSystemConfigItem.bizSystemDesc =~ {bizSystemDesc}");
            queryParams.put("bizSystemDesc", appendLike(domain.getBizSystemDesc()));
        }

        return stringBuffer.toString();
    }
}
