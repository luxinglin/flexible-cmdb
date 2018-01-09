package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.NodeOfNetwork;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@Repository
public interface NetworkRepository extends PagingAndSortingRepository<NodeOfNetwork, Long> {
}
