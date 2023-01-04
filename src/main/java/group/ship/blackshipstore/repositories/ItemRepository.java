package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ItemRepository extends BaseRepository<Item> {

    List<Item> findAllByCategoryId(Long categoryId);
}
