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
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Service
@Transactional(readOnly = true)
public class OrderService {

    private final OrderRepository orderRepository;

    private final StatusRepository statusRepository;

    @Autowired
    public OrderService(OrderRepository orderRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.statusRepository = statusRepository;
    }

    /**
    Mapping Order entity to OrderResponseDto
    */
    public OrderResponseDto entityToDto(Order order) {
        return mapper.map(order, OrderResponseDto.class);
    }

    /**
     Mapping OrderResponseDto entity to Order
     */
    public Order dtoToEntity(OrderResponseDto dto) {
        return mapper.map(dto, Order.class);
    }

    /**
     Mapping List of Order entity to List of OrderResponseDto
     */
    public List<OrderResponseDto> entityToDto(List<Order> orders) {
        List<OrderResponseDto> dtoList = new ArrayList<>();
        orders.forEach(order -> dtoList.add(mapper.map(order, OrderResponseDto.class)));
        return dtoList;
    }

    /**
     Mapping List of OrderResponseDto entity to List of Order
     */
    public List<Order> dtoToEntity(List<OrderResponseDto> dtoList) {
        List<Order> orders = new ArrayList<>();
        dtoList.forEach(dto -> orders.add(mapper.map(dto, Order.class)));
        return orders;
    }

    /**
     Gets all Orders of one Pirate and sorting in by order date
     @param pirateId - Pirate Id
     */
    public List<OrderResponseDto> getAllOrdersByPirateIdOrderByOrderDate(Long pirateId) {
        return orderRepository.findAllByPirateIdOrderByOrderDate(pirateId).stream()
                .map(orderDtoFunction)
                .toList();
    }
    /**
     Gets all Orders of one Pirate with one Status and sorting in by order date
     @param pirateId - Pirate Id
     @param status - Status ID
     */
    public List<OrderResponseDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(Long pirateId, Long status) {
        return orderRepository.findAllByPirateIdAndStatusIdOrderByOrderDate(pirateId, status).stream()
                .map(orderDtoFunction)
                .toList();
    }

    /**
     Gets all Orders with one Status and sorting in by order date
     @param status - Status id
     */
    public List<OrderResponseDto> getAllOrdersByStatusIdOrderByOrderDate(Long status) {
        return orderRepository.findAllByStatusIdOrderByOrderDate(status).stream()
                .map(orderDtoFunction)
                .toList();
    }

    /**
     Gets Last order of Pirate
     @param id - Pirate id
     */
    public OrderResponseDto getLastPirateOrderByPirateId(Long id) {
        List<OrderResponseDto> orders = getAllOrdersByPirateIdOrderByOrderDate(id);
        return orders.get(orders.size() -1);
    }

    /**
     Marks order as completed by setting it's completed date and status
     @param id - Order id
     */
    public OrderResponseDto markAsCompleted(Long id) {
        LocalDate currentDate = LocalDate.now();
        Optional<Order> order = orderRepository.findById(id);
        order.ifPresent(order1 -> {
            order1.setCompletedDate(currentDate);
            order1.setStatus(statusRepository.findById(1L).orElse(null));
            orderRepository.save(order1);
        });

        return entityToDto(order.orElseThrow());
    }

    /**
     Adds new order if Pirate has no other uncompleted orders
     */
    public OrderResponseDto addNewOrderOrReturnLastUncompleted(HttpServletRequest request) {
        String username = jwtParser.parseUsernameFromRequest(request);
        Pirate pirate = pirateService.findByUsername(username).orElseThrow();
        OrderResponseDto lastOrder = getLastPirateOrderByPirateId(pirate.getId());
        if (lastOrder.getStatusName().equalsIgnoreCase("Выполнен")) {
            Order order = new Order();
            order.setPirate(pirate);
            order.setOrderDate(LocalDate.now());
            orderRepository.save(order);
            return entityToDto(order);
        } else {
            return  lastOrder;
        }
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
