package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Role;

import java.util.Optional;

public interface RoleRepository extends BaseRepository<Role>{

    Optional<Role> findByName(String name);
}
