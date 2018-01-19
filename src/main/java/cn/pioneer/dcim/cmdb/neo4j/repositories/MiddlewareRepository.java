package cn.pioneer.dcim.cmdb.neo4j.repositories;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:02
 **/
@Repository
public interface MiddlewareRepository extends PagingAndSortingRepository<MiddlewareConfigItem, Long> {
}
