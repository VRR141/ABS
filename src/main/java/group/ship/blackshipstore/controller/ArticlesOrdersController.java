package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ArticleOrder;
import group.ship.blackshipstore.sevices.ArticlesOrdersService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/articles_orders")
public class ArticlesOrdersController {
    private final ArticlesOrdersService articlesOrdersService;


    public ArticlesOrdersController(ArticlesOrdersService articlesOrdersService) {
        this.articlesOrdersService = articlesOrdersService;
    }

    @GetMapping()
    public List<ArticleOrder> getAllArticlesOrders(){
        return articlesOrdersService.findAll();
    }

    @GetMapping("/{id}")
    public ArticleOrder getArticlesOrders(@PathVariable("id") int id) {
        return articlesOrdersService.findOne(id);
    }

    @PutMapping("/{orderId}")
    public Article addArticleToOrder(@PathVariable Long orderId, Article article) {
        articlesOrdersService.addArticleToOrder(orderId, article);
        return article;
    }

    @GetMapping("/price/{orderId}")
    public AtomicLong getTotalPrice(@PathVariable Long orderId) {
        return articlesOrdersService.getTotalPrice(orderId);
    }
}
