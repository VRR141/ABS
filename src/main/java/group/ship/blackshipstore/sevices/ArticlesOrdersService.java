package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.ArticleOrder;
import group.ship.blackshipstore.repositories.ArticlesOrdersRepository;
import group.ship.blackshipstore.repositories.ArticlesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ArticlesOrdersService {
    private final ArticlesOrdersRepository articlesOrdersRepository;

    public ArticlesOrdersService(ArticlesOrdersRepository articlesOrdersRepository) {
        this.articlesOrdersRepository = articlesOrdersRepository;
    }

    public List<ArticleOrder> findAll(){
        return articlesOrdersRepository.findAll();
    }

    public ArticleOrder findeOne(int id) {
        Optional<ArticleOrder> articleOrder = articlesOrdersRepository.findById(id);
        return articleOrder.orElse(null);
    }
}
