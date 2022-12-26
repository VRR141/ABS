package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.sevices.ArticlesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/article")
public class ArticleController {
    private final ArticlesService articlesService;

    public ArticleController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }
    @GetMapping()
    public List<Article> getArticles() {
        return articlesService.findAll();
    }
}
