package cn.pioneer.dcim.cmdb.repositories;

import cn.pioneer.dcim.cmdb.domain.entity.BizSystemConfigItem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Collection;

/**
 * test curd
 *
 * @author luxinglin
 * @since 2018-08-08
 */
@Repository
public interface BizSystemRepository extends PagingAndSortingRepository<BizSystemConfigItem, Long> {
    /**
     * @param name
     * @return
     */
    BizSystemConfigItem findByName(@Param("name") String name);

    /**
     * @param name
     * @return
     */
    Collection<BizSystemConfigItem> findByNameLike(@Param("name") String name);

    /**
     * @param limit
     * @return
     */
    @Query("MATCH (m:BizSystemConfigItem)-[r]->(n) return m,r,n LIMIT {limit}")
//    @Query("MATCH (p:Person)<-[r0:BELONG_TO]-(m:BizSystemConfigItem)-[r1:DEPLOY_ON]->(s:ServerConfigItem)<-[r2:SERVER_NETWORK_LINK]-(n:NetworkConfigItem) return * LIMIT {limt}")
    Collection<BizSystemConfigItem> graph(@Param("limit") int limit);

    /**
     * @param id
     * @param limit
     * @return
     */
    @Query("MATCH (m:BizSystemConfigItem)-[r]->(n) where ID(m)={id} return m,r,n LIMIT {limit}")
    Collection<BizSystemConfigItem> graph(@Param("id") Long id, @Param("limit") int limit);
}
