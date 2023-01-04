package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.repositories.OrderRepository;
import group.ship.blackshipstore.repositories.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {

    private final OrderRepository orderRepository;

    private final StatusRepository statusRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }

    /*
    Mapping Order entity to OrderDto
    */
    private final Function<Order, OrderResponseDto> orderDtoFunction = entity -> {
        OrderResponseDto orderResponseDto = new OrderResponseDto(entity.getId());
        orderResponseDto.setStatus(entity.getStatus());
        orderResponseDto.setOrderDate(entity.getOrderDate());
        orderResponseDto.setCompletedDate(entity.getCompletedDate());
        return orderResponseDto;
    };

    public List<OrderResponseDto> getAllOrdersByPirateIdOrderByOrderDate(Long pirateId) {
        return orderRepository.findAllByPirateIdOrderByOrderDate(pirateId).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long status) {
        return orderRepository.findAllByPirateIdAndStatusIdOrderByOrderDate(pirateId, status).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }

    public List<OrderResponseDto> getAllOrdersByStatusIdOrderByOrderDate(Long status) {
        return orderRepository.findAllByStatusIdOrderByOrderDate(status).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }

    public OrderResponseDto getLastPirateOrderByPirateId(Long id) {
        List<OrderResponseDto> orders = getAllOrdersByPirateIdOrderByOrderDate(id);
        return orders.get(orders.size() -1);
    }

    public OrderResponseDto markAsCompleted(Long id) {
        LocalDate currentDate = LocalDate.now();
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(order1 -> {
            order1.setCompletedDate(currentDate);
            order1.setStatus(statusRepository.findById(1L).orElse(null));
            orderRepository.save(order1);
        });
        return order.map(orderDtoFunction).orElse(null);
    }

    public void addOrderByPirateId(Order order) {
        orderRepository.save(order);
    }

    public void addArticlesInOrder(Article article, Long id) {
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(order1 -> {
            order1.getArticles().add(article);
            orderRepository.save(order1);
        });
    }
}
