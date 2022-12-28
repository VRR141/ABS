package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.sevices.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }
    @GetMapping("/{id}")
    public List<Order> findAllByPirateId(@PathVariable Integer id) {
        return orderService.findAllByPirateId(id);
    }

    @GetMapping("unique/{id}")
    public Order findDistinctTopByPirateId(@PathVariable Integer id) {
        return orderService.findDistinctTopByPirateId(id);
    }


}
