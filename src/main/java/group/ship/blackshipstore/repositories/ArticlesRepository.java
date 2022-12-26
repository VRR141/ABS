package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticlesRepository extends JpaRepository<Article,Integer> {
}
