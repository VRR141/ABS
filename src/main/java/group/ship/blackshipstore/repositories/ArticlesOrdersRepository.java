package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.ArticleOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesOrdersRepository extends JpaRepository<ArticleOrder,Integer> {
}
