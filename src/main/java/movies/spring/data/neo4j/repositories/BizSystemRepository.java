package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.BizSystem;
import org.springframework.data.neo4j.annotation.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;

/**
 * test curd
 *
 * @author luxinglin
 * @since 2018-08-08
 */
@RepositoryRestResource(collectionResourceRel = "bizSystems", path = "bizSystems")
public interface BizSystemRepository extends PagingAndSortingRepository<BizSystem, Long> {
    /**
     * @param name
     * @return
     */
    BizSystem findByName(@Param("name") String name);

    /**
     * @param name
     * @return
     */
    Collection<BizSystem> findByNameLike(@Param("name") String name);

    /**
     * @param limit
     * @return
     */
    @Query("MATCH (m:BizSystem)<-[r:RELEATED_TO]-(a:Person) RETURN m,r,a LIMIT {limit}")
    Collection<BizSystem> graph(@Param("limit") int limit);
}
