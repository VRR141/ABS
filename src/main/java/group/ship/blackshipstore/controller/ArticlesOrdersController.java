package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.ArticleOrder;
import group.ship.blackshipstore.sevices.ArticlesOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

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
        return articlesOrdersService.findeOne(id);
    }
}
