package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.repositories.OrderRepository;
import group.ship.blackshipstore.security.jwt.JwtParser;
import jakarta.servlet.http.HttpServletRequest;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    private final StatusService statusService;

    private final PirateService pirateService;

    private final JwtParser jwtParser;

    private final ModelMapper mapper;

    @Autowired
    public OrderService(OrderRepository orderRepository, JwtParser jwtParser,
                        StatusService statusService, PirateService pirateService, ModelMapper mapper) {
        this.orderRepository = orderRepository;
        this.jwtParser = jwtParser;
        this.statusService = statusService;
        this.pirateService = pirateService;
        this.mapper = mapper;
    }

    /*
    Mapping Order entity to OrderDto
    */
    final Function<Order, OrderResponseDto> orderDtoFunction = order -> {
        OrderResponseDto orderResponseDto = new OrderResponseDto();
        orderResponseDto.setId(order.getId());
//        orderResponseDto.setPirate(order.getPirate());
//        orderResponseDto.setStatus(order.getStatus());
        orderResponseDto.setOrderDate(order.getOrderDate());
        orderResponseDto.setCompletedDate(order.getCompletedDate());
        return orderResponseDto;
    };

    public OrderResponseDto entityToDto(Order order) {
        return mapper.map(order, OrderResponseDto.class);
    }

    public Order dtoToEntity(OrderResponseDto dto) {
        return mapper.map(dto, Order.class);
    }

    public List<OrderResponseDto> entityToDto(List<Order> orders) {
        List<OrderResponseDto> dtoList = new ArrayList<>();
        orders.forEach(order -> dtoList.add(mapper.map(order, OrderResponseDto.class)));
        return dtoList;
    }

    public List<Order> dtoToEntity(List<OrderResponseDto> dtoList) {
        List<Order> orders = new ArrayList<>();
        dtoList.forEach(dto -> orders.add(mapper.map(dto, Order.class)));
        return orders;
    }

    public List<OrderResponseDto> getAllOrdersByPirateIdOrderByOrderDate(Long pirateId) {
        List<Order> orders = orderRepository.findAllByPirateIdOrderByOrderDate(pirateId);
        return entityToDto(orders);
    }

    public List<OrderResponseDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long status) {
        List<Order> orders = orderRepository.findAllByPirateIdAndStatusIdOrderByOrderDate(pirateId, status);
        return entityToDto(orders);
    }

    public List<OrderResponseDto> getAllOrdersByStatusIdOrderByOrderDate(Long status) {
        List<Order> orders = orderRepository.findAllByStatusIdOrderByOrderDate(status);
        return entityToDto(orders);
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
            order1.setStatus(statusService.getById(1L));
            orderRepository.save(order1);
        });
        return entityToDto(order.orElseThrow());
    }

    public OrderResponseDto addNewOrderOrReturnLastUncompleted(HttpServletRequest request) {
        String username = jwtParser.parseUsernameFromRequest(request);
        Pirate pirate = pirateService.findByUsername(username).orElseThrow();
        OrderResponseDto lastOrder = getLastPirateOrderByPirateId(pirate.getId());
        if (lastOrder.getStatus().getId() != 1L) {
            Order order = new Order();
            order.setPirate(pirate);
            order.setOrderDate(LocalDate.now());
            orderRepository.save(order);
            return orderDtoFunction.apply(order);
        } else {
            return  lastOrder;
        }
    }

    public Order getById (Long id) {
        return orderRepository.findById(id).orElseThrow();
    }

    public void save(Order order) {
        orderRepository.save(order);
    }
}
