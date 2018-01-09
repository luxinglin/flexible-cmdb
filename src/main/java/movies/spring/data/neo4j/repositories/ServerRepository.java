package movies.spring.data.neo4j.repositories;

import movies.spring.data.neo4j.domain.NodeOfServer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author luxinglin
 * @since 2018-01-09
 */
@Repository
public interface ServerRepository extends PagingAndSortingRepository<NodeOfServer, Long> {
}
