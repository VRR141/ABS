package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Status;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StatusRepository extends BaseRepository<Status> {

    Optional<Status> findByName(String name);

    boolean existsByName(String name);
}
