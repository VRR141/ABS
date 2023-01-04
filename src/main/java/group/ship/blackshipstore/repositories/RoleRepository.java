package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Role;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends BaseRepository<Role>{

    Optional<Role> findByName(String name);
}
