package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

@org.springframework.stereotype.Repository
public interface Repository extends JpaRepository<Item, Long> {
}
