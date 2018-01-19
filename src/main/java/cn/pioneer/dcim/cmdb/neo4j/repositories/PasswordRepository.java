package cn.pioneer.dcim.cmdb.neo4j.repositories;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.PasswordConfigItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-15 13:40
 **/
@Repository
public interface PasswordRepository extends PagingAndSortingRepository<PasswordConfigItem, Long> {
}
