package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.sevices.OrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/pirate/{id}")
    public List<OrderResponseDto> getAllOrdersByPirateIdOrderByOrderDate(
            @PathVariable Long id) {
        return orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
    }

    @GetMapping("pirate/{id}?statusId={statusId}")
    public List<OrderResponseDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(
            @PathVariable Long id,
            @PathParam(value = "statusId") Long statusId) {
        return orderService.getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(id, statusId);
    }

    @GetMapping("/status/{id}")
    public List<OrderResponseDto> getAllOrdersByStatusIdOrderByOrderDate(
            @PathVariable Long id) {
        return orderService.getAllOrdersByStatusIdOrderByOrderDate(id);
    }

    @GetMapping("pirateLast/{id}")
    public OrderResponseDto getLastOrderByPirateId(@PathVariable Long id) {
        return orderService.getLastPirateOrderByPirateId(id);
    }

    @PatchMapping("completed/{id}")
    public OrderResponseDto markAsCompleted(@PathVariable Long id) {
        return orderService.markAsCompleted(id);
    }

    @PostMapping("")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrderByPirateId(order);
    }

    @PatchMapping("articles/{id}")
    public void addArticlesInOrder(Article article, @PathVariable Long id) {
        orderService.addArticlesInOrder(article, id);
    }
}