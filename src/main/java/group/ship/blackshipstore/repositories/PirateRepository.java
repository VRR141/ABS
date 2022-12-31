package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface PirateRepository extends JpaRepository<Pirate, Long> {
}
