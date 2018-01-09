package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.NodeOfBizSystem;
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
public interface BizSystemRepository extends PagingAndSortingRepository<NodeOfBizSystem, Long> {
    /**
     * @param name
     * @return
     */
    NodeOfBizSystem findByName(@Param("name") String name);

    /**
     * @param name
     * @return
     */
    Collection<NodeOfBizSystem> findByNameLike(@Param("name") String name);

    /**
     * @param limit
     * @return
     */
    @Query("MATCH (m:NodeOfBizSystem)-[r]->(n) return m,r,n LIMIT {limit}")
    Collection<NodeOfBizSystem> graph(@Param("limit") int limit);

}
