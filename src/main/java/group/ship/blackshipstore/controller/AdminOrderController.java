package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.sevices.OrderService;
import group.ship.blackshipstore.sevices.PersonalAccountService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
@PreAuthorize("hasAnyAuthority('Капитан')")
public class AdminOrderController {
    private final OrderService orderService;

    private final PersonalAccountService accountService;

    @Autowired
    public AdminOrderController(OrderService orderService, PersonalAccountService accountService) {
        this.orderService = orderService;
        this.accountService = accountService;
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
    public void addOrder(HttpServletRequest request) {
        orderService.addNewOrderOrReturnLastUncompleted(request);
    }

    @PatchMapping("articles")
    public void addArticlesInOrder(Article article, HttpServletRequest request) {
        accountService.addArticleInOrder(article, request);
    }
}