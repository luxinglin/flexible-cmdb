package cn.pioneer.dcim.cmdb.repositories;

import cn.pioneer.dcim.cmdb.domain.entity.PersonConfigItem;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

/**
 * @author pdtyreus
 * @author Mark Angrish
 */
@Repository
public interface PersonRepository extends PagingAndSortingRepository<PersonConfigItem, Long> {

}
