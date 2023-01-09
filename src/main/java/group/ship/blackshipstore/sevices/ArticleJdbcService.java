package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.LonelyArticle;
import group.ship.blackshipstore.repositories.ArticleJdbcRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArticleJdbcService {
    
    private ArticleJdbcRepository articleJdbcRepository;

    @Autowired
    public ArticleJdbcService(ArticleJdbcRepository articleJdbcRepository) {
        this.articleJdbcRepository = articleJdbcRepository;
    }
    
    public List<LonelyArticle> getAllArticles(){
        List<LonelyArticle> result = articleJdbcRepository.getAllArticles();
        return result;
    }

    public LonelyArticle getArticle(Long id){
        LonelyArticle result = articleJdbcRepository.getArticle(id);
        return result;
    }
}
