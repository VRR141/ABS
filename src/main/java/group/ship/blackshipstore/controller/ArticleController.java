package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.sevices.ArticlesService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/articles")
@Tag(name = "Article Controller", description = "Controller to find Articles")
public class ArticleController {
    private final ArticlesService articlesService;

    public ArticleController(ArticlesService articlesService) {
        this.articlesService = articlesService;
    }

    @GetMapping()
    @Operation(summary = "Get all Articles", description = "Return list of all Articles")
    public List<Article> getArticles() {
        return articlesService.findAll();
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Article by id", description = "Return Article by id")
    public Article getArticle(@PathVariable("id") Long id) {
        return articlesService.findOne(id);
    }
}
