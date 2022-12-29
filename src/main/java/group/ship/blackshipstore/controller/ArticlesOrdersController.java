package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ArticleOrder;
import group.ship.blackshipstore.sevices.ArticlesOrdersService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/articles_orders")
@Tag(name = "Articles-Orders Controller", description = "Controller to get Articles from Order and add Articles to Order")
public class ArticlesOrdersController {
    private final ArticlesOrdersService articlesOrdersService;

    public ArticlesOrdersController(ArticlesOrdersService articlesOrdersService) {
        this.articlesOrdersService = articlesOrdersService;
    }

    @GetMapping()
    @Operation(summary = "Get all Articles from all Orders", description = "Return List of all Articles and Orders")
    public List<ArticleOrder> getAllArticlesOrders(){
        return articlesOrdersService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Article and what Order it is from", description = "Return pare Article-Order")
    public ArticleOrder getArticlesOrders(@PathVariable("id") int id) {
        return articlesOrdersService.findOne(id);
    }

    @PutMapping("/{orderId}")
    @Operation(summary = "Put Article to Order", description = "Return Article that were added to the Order by Order id")
    public Article addArticleToOrder(@PathVariable Long orderId, Article article) {
        articlesOrdersService.addArticleToOrder(orderId, article);
        return article;
    }

    @GetMapping("/price/{orderId}")
    @Operation(summary = "Get total Article price in the Order", description = "Return the price of all Articles in an Order by Order id")
    public AtomicLong getTotalPrice(@PathVariable Long orderId) {
        return articlesOrdersService.getTotalPrice(orderId);
    }
}
