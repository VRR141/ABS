package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.ArticleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticlesOrdersRepository extends JpaRepository<ArticleOrder, Long> {

    public List<Article> findArticlesByOrderId(Long orderId);
}
