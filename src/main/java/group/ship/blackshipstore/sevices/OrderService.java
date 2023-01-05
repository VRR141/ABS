package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
public class OrderService {
    private final OrderRepository orderRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    /*
    Mapping Order entity to OrderDto
    */
    private final Function<Order, OrderResponseDto> orderDtoFunction = order -> {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
//        orderResponseDto.setPirate(order.getPirate());
//        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setCompletedDate(order.getCompletedDate());
        return orderResponseDto;
    };

    public List<OrderResponseDto> getAllOrdersByPirateIdOrderByOrderDate(Long pirateId) {
        return orderRepository.findAllByPirateIdOrderByOrderDate(pirateId).stream()
                .map(orderDtoFunction)
                .toList();
    }

    public List<OrderResponseDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long status) {
        return orderRepository.findAllByPirateIdAndStatusIdOrderByOrderDate(pirateId, status).stream()
                .map(orderDtoFunction)
                .toList();
    }

    public List<OrderResponseDto> getAllOrdersByStatusIdOrderByOrderDate(Long status) {
        return orderRepository.findAllByStatusIdOrderByOrderDate(status).stream()
                .map(orderDtoFunction)
                .toList();
    }
}
