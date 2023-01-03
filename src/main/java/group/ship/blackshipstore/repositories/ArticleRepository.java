package group.ship.blackshipstore.repositories;

import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Item;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends BaseRepository<Article> {

    List<Article> findAllByItemId(Item itemId);

    List<Article> findAllByItemCategoryId(Long categoryId);
}
