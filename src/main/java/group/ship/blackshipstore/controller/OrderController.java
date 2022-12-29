package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.sevices.OrderService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    public List<Order> getAllOrdersByPirateId(@PathVariable Integer id) {
        return orderService.getAllOrdersByPirateId(id);
    }

    @GetMapping("/unique/{id}")
    public Order getLastOrderByPirateId(@PathVariable Integer id) {
        return orderService.getLastOrderByPirateId(id);
    }

    @PutMapping("/{id}")
    public Order markOrderAsCompleted(@PathVariable Integer id) {
        return orderService.markOrderAsCompleted(id);
    }

    @PostMapping("/{id}")
    public void addOrder(@PathVariable Integer id) {
        orderService.addOrderByPirateId(id);
    }
}
