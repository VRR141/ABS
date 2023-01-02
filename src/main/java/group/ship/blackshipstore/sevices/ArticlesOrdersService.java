package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ArticleOrder;
import group.ship.blackshipstore.repositories.ArticlesOrdersRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

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

    public ArticleOrder findOne(Long id) {
        Optional<ArticleOrder> articleOrder = articlesOrdersRepository.findById(id);
        return articleOrder.orElse(null);
    }

    public void addArticleToOrder(Long orderId, Article article) {
        List<Article> articles = articlesOrdersRepository.findArticlesByOrderId(orderId);
        articles.add(article);
    }

    public AtomicLong getTotalPrice(Long orderId) {
        AtomicLong totalPrice = new AtomicLong();
        articlesOrdersRepository.findArticlesByOrderId(orderId).forEach(article -> totalPrice.addAndGet(article.getPrice()));
        return totalPrice;
    }
}
