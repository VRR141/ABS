package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}