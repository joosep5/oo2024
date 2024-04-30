package ee.tlu.salat.repository;

import ee.tlu.salat.entity.ToiduaineEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ToiduaineRepository extends JpaRepository<ToiduaineEntity, String> {
    // Saan siia kirjutada custom repostitory käske, mis tagastavad kas ToiduaineEntity või List<ToiduaineEntity>
    // SELECT * FROM Toiduained WHERE valk >= 5;

    List<ToiduaineEntity> findAllByValkGreaterThan(int valk);
    List<ToiduaineEntity> findAllBySysivesikBetween(int min, int max);
}
