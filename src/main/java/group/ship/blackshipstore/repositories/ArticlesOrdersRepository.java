package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ArticleOrder;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesOrdersRepository extends BaseRepository<ArticleOrder> {

    public List<Article> findArticlesByOrderId(Long orderId);
}
