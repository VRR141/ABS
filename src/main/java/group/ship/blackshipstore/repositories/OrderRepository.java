package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Order;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    List<Order> findAllByPirateId(Long id);

}