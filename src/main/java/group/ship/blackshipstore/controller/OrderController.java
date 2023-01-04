package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.sevices.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/orders")
@Tag(name = "Order Controller", description = "Order controller")
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
}