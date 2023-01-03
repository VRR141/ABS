package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.OrderDto;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.entity.Status;
import group.ship.blackshipstore.repositories.OrderRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderService {
    private final OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /*
    Mapping Order entity to OrderDto
    */
    private final Function<Order, OrderDto> orderDtoFunction = entity -> {
        OrderDto orderDto = new OrderDto(entity.getUuid());
        orderDto.setStatus(entity.getStatus());
        orderDto.setOrderDate(entity.getOrderDate());
        orderDto.setCompletedDate(entity.getCompletedDate());
        return orderDto;
    };

    public List<OrderDto> getAllOrdersByPirateIdOrderByOrderDate(Long pirateId) {
        return orderRepository.findAllByPirateIdOrderByOrderDate(pirateId).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long status) {
        return orderRepository.findAllByPirateIdAndStatusIdOrderByOrderDate(pirateId, status).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }

    public List<OrderDto> getAllOrdersByStatusIdOrderByOrderDate(Long status) {
        return orderRepository.findAllByStatusIdOrderByOrderDate(status).stream()
                .map(orderDtoFunction)
                .collect(Collectors.toList());
    }
}
