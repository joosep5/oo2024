package ee.tlu.salat;

import org.springframework.data.jpa.repository.JpaRepository;

// extends CrudRepository<>
// extends SortingAndPagingRepository<>
public interface ToidukomponentRepository extends JpaRepository<Toidukomponent, Long> {
}
