package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ItemValues;
import group.ship.blackshipstore.sevices.ArticlesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
public class ArticleController {
    private final ArticlesService articlesService;

    public ArticleController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }
    @GetMapping()
    public List<Article> getArticles() {
        return articlesService.findAll();
    }

    @GetMapping("/{id}")
    public Article getArticle(@PathVariable("id") int id) {
        return articlesService.findOne(id);
    }
}
