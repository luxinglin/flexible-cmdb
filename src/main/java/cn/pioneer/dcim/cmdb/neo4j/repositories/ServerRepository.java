package cn.pioneer.dcim.cmdb.neo4j.repositories;

import cn.pioneer.dcim.cmdb.neo4j.domain.entity.ServerConfigItem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@Repository
public interface ServerRepository extends PagingAndSortingRepository<ServerConfigItem, Long> {
    /**
     * @param limit
     * @return
     */
    @Query("MATCH (m:ServerConfigItem)-[r]-(n) return m,r,n LIMIT {limit}")
    Collection<ServerConfigItem> graph(@Param("limit") int limit);

    /**
     * @param id
     * @param limit
     * @return
     */
    @Query("MATCH (n)-[r]->(m:ServerConfigItem) where ID(m)={id} return m,r,n LIMIT {limit}")
    Collection<ServerConfigItem> graph(@Param("id") Long id, @Param("limit") int limit);
}
