package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.entity.Status;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<Order> {

    List<Order> findAllByPirateIdOrderByOrderDate(Long pirateId);

    List<Order> findAllByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long statusId);

    List<Order> findAllByStatusIdOrderByOrderDate(Long statusId);
}