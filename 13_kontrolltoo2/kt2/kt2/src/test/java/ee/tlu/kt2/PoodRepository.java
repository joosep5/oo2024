package ee.tlu.kt2;

import org.springframework.boot.SpringApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PoodRepository extends JpaRepository<Pood, Long> {
    public static void main(String[] args) {
        SpringApplication.run(Kt2Application.class, args);
    }

    List<StoreEntity> findByAvamineLessThanEqualAndSulgemineGreaterThanEqual(int avamine, int sulgemine);

    List<StoreEntity> findByKulastamine(int kulastamine);

    List<Pood> findByAvamisAegGreaterThanAndSulgemisAegLessThan(int kell, int kell1);

    Pood findByNimetus(String nimetus);

    Pood findFirstByOrderByKulastunuteArvDesc();
}
