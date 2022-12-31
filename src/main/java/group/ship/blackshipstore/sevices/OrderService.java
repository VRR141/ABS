package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public List<Order> getAllOrdersByPirateId(Integer id) {
        return orderRepository.findAllByPirateId(id);
    }

    public Order getLastOrderByPirateId(Integer id) {
        return orderRepository.findDistinctTopByPirateId(id);
    }

    public Order markOrderAsCompleted(Long id) {
        Date currentDate = new Date();
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent((order1) -> {
                order1.setCompletedDate(currentDate);
                orderRepository.save(order1);
        });
        return order.orElse(null);
    }
    public void addOrderByPirate(Order order) {
        orderRepository.save(order);
    }

}
