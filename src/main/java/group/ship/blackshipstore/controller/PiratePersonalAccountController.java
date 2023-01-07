package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.sevices.PersonalAccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("hasAuthority('Пират')")
public class PiratePersonalAccountController {

    private final PersonalAccountService accountService;

    @Autowired
    public PiratePersonalAccountController(PersonalAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getSelfOrders(HttpServletRequest request) {
        List<OrderResponseDto> result = accountService.getSelfOrders(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("orders/addArticle/{id}")
    public ResponseEntity<OrderResponseDto> addArticleInOrder(Article article, HttpServletRequest request) {
        return new ResponseEntity<>(accountService.addArticleInOrder(article, request), HttpStatus.OK);
    }

    @PatchMapping("orders/deleteArticle/{id}")
    public ResponseEntity<OrderResponseDto> deleteArticleInOrder(Article article, HttpServletRequest request) {
        return new ResponseEntity<>(accountService.deleteArticleInOrder(article, request), HttpStatus.OK);
    }
}
