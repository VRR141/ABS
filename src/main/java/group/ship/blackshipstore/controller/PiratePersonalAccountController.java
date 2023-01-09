package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.LonelyArticle;
import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.sevices.ArticleJdbcService;
import group.ship.blackshipstore.sevices.PersonalAccountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("hasAuthority('Пират')")
public class PiratePersonalAccountController {

    private final PersonalAccountService accountService;

    private final ArticleJdbcService articleJdbcService;

    @Autowired
    public PiratePersonalAccountController(
            PersonalAccountService accountService,
            ArticleJdbcService articleJdbcService) {
        this.accountService = accountService;
        this.articleJdbcService = articleJdbcService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getSelfOrders(HttpServletRequest request) {
        List<OrderResponseDto> result = accountService.getSelfOrders(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @PatchMapping("addArticles/{id}")
    public void addArticlesInOrder(@PathVariable Long id, HttpServletRequest request) {
        accountService.addArticleInOrder(id, request);
    }

    @PatchMapping("deleteArticles/{id}")
    public void deleteArticlesInOrder(@PathVariable Long id, HttpServletRequest request) {
        accountService.deleteArticleInOrder(id, request);
    }

    @GetMapping("/articles")
    public ResponseEntity<List<LonelyArticle>> getAllArticles(){
        return new ResponseEntity<>(articleJdbcService.getAllArticles(), HttpStatus.OK);
    }

    @GetMapping("/articles/{id}")
    public ResponseEntity<LonelyArticle> getArticles(@PathVariable long id){
        return new ResponseEntity<>(articleJdbcService.getArticle(id), HttpStatus.OK);
    }
}