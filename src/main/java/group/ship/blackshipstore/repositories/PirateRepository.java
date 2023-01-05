package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Pirate;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PirateRepository extends BaseRepository<Pirate> {

    Optional<Pirate> findByUsername(String username);

    boolean existsByUsername(String username);
}
