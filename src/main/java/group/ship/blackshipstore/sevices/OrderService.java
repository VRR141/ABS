package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> findAllByPirateId(Integer id) {
        return orderRepository.findAllByPirateId(id);
    }

    public Order findDistinctTopByPirateId(Integer id) {
        return orderRepository.findDistinctTopByPirateId(id);
    }
}
