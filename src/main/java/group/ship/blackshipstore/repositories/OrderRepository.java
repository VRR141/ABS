package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends JpaRepository<Order, Integer> {

    public List<Order> findAllByPirateId(Integer id);

    public Order findDistinctTopByPirateId(Integer id);

}
