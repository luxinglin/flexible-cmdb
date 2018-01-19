package cn.pioneer.dcim.cmdb.neo4j.repositories;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.MiddlewareConfigItem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author luxinglin
 * @version 1.0
 * @Description: TODO
 * @create 2018-01-19 14:02
 **/
@Repository
public interface MiddlewareRepository extends PagingAndSortingRepository<MiddlewareConfigItem, Long> {

    /**
     * @param limit
     * @return
     */
    @Query("MATCH (m:MiddlewareConfigItem)-[r]->(n) return m,r,n LIMIT {limit}")
    Collection<MiddlewareConfigItem> graph(@Param("limit") int limit);

    /**
     * @param id
     * @param limit
     * @return
     */
    @Query("MATCH (m:MiddlewareConfigItem)-[r]->(n) where ID(m)={id} return m,r,n LIMIT {limit}")
    Collection<MiddlewareConfigItem> graph(@Param("id") Long id, @Param("limit") int limit);
}
