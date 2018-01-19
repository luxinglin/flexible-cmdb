package cn.pioneer.dcim.cmdb.neo4j.repositories;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.NetworkConfigItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@Repository
public interface NetworkRepository extends PagingAndSortingRepository<NetworkConfigItem, Long> {
}
