package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.OrderDto;
import group.ship.blackshipstore.sevices.OrderService;
import jakarta.websocket.server.PathParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("/pirate/{id}")
    public List<OrderDto> getAllOrdersByPirateIdOrderByOrderDate(
            @PathVariable Long id) {
        return orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
    }

    @GetMapping("pirate/{id}?statusId={statusId}")
    public List<OrderDto> getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(
            @PathVariable Long id,
            @PathParam(value = "statusId") Long statusId) {
        return orderService.getAllOrdersByPirateIdAndStatusIdOrderByOrderDate(id, statusId);
    }

    @GetMapping("/status/{id}")
    public List<OrderDto> getAllOrdersByStatusIdOrderByOrderDate(
            @PathVariable Long id) {
        return orderService.getAllOrdersByStatusIdOrderByOrderDate(id);
    }
}