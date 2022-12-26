package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Item;
import group.ship.blackshipstore.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ArticlesService {
    private final ArticlesRepository articlesRepository;

    public ArticlesService(ArticlesRepository articlesRepository) {
        this.articlesRepository = articlesRepository;
    }
    public List<Article> findAll(){
        return articlesRepository.findAll();
    }
}
