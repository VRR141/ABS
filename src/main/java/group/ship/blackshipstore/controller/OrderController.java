package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.sevices.OrderService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
@Tag(name = "Order Controller", description = "Controller to get Pirate Orders")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    @Operation(summary = "Get all Pirate Orders", description = "Return list of all Orders by Pirate id")
    public List<Order> getAllOrdersByPirateId(@PathVariable Integer id) {
        return orderService.getAllOrdersByPirateId(id);
    }

    @GetMapping("/unique/{id}")
    @Operation(summary = "Get last Pirate Order", description = "Return last Order by Pirate id")
    public Order getLastOrderByPirateId(@PathVariable Integer id) {
        return orderService.getLastOrderByPirateId(id);
    }

    @PutMapping("/{id}")
    @Operation(summary = "Mark Order completed", description = "Return Order that has been marked as completed by id")
    public Order markOrderAsCompleted(@PathVariable Integer id) {
        return orderService.markOrderAsCompleted(id);
    }

    @PostMapping("/add")
    @Operation(summary = "Add Order to Pirate", description = "Add Order to Pirate by Pirate id")
    public void addOrder(@RequestBody Order order) {
        orderService.addOrderByPirate(order);
    }
}
