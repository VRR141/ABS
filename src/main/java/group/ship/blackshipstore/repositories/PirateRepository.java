package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Pirate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PirateRepository extends JpaRepository<Pirate, Integer> {
}
