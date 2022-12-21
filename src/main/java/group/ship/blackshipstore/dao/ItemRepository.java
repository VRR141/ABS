package group.ship.blackshipstore.dao;

import group.ship.blackshipstore.entity.Category;
import group.ship.blackshipstore.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> getItemsByCategory(Category category);
}
