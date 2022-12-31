package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.repositories.OrderRepository;
import group.ship.blackshipstore.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class OrderService {

    @Autowired
    private final OrderRepository orderRepository;

    @Autowired
    private final StatusRepository statusRepository;

    public OrderService(OrderRepository orderRepository,
                        StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }

    public List<Order> getAllOrdersByPirateId(Long id) {
        return orderRepository.findAllByPirateId(id);
    }

    public Order getLastOrderByPirateId(Long id) {
        List<Order> orders = orderRepository.findAllByPirateId(id);
        orders.sort(Comparator.comparing(Order::getOrderDate));
        return orders.get(orders.size() - 1);
    }

    public Order markOrderAsCompleted(Long id) {
        LocalDate currentDate = LocalDate.now();
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent((order1) -> {
            order1.setCompletedDate(currentDate);
            order1.setStatus(statusRepository.findById(1L).orElse(null));
            orderRepository.save(order1);
        });
        return order.orElse(null);
    }

    public void addOrderByPirate(Order order) {
        orderRepository.save(order);
    }

}
