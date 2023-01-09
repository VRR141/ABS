package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.repositories.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleService {

    private final ArticleRepository articleRepository;

    @Autowired
    public ArticleService(ArticleRepository articleRepository) {
        this.articleRepository = articleRepository;
    }

    public Article getArticleById(Long id) {
        return articleRepository.findById(id).orElseThrow();
    }

    public void save(Article article) {
        articleRepository.save(article);
    }
}
