package ee.tlu.auto;

import org.springframework.data.jpa.repository.JpaRepository;

// extends CrudRepository<>
// extends SortingAndPagingRepository<>
public interface AutokomponentRepository extends JpaRepository<Autokomponent, Long> {
}
