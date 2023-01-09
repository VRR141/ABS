package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
import group.ship.blackshipstore.entity.Order;
import group.ship.blackshipstore.security.jwt.JwtParser;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonalAccountService {

    private final OrderService orderService;

    private final JwtParser jwtParser;

    private final PirateService pirateService;

    private final ArticleService articleService;

    @Autowired
    public PersonalAccountService(OrderService orderService,
                                  JwtParser jwtParser,
                                  PirateService pirateService, ArticleService articleService) {
        this.orderService = orderService;
        this.jwtParser = jwtParser;
        this.pirateService = pirateService;
        this.articleService = articleService;
    }

    public List<OrderResponseDto> getSelfOrders(HttpServletRequest request){
        String username = jwtParser.parseUsernameFromRequest(request);
        Long id = pirateService.findByUsernameCacheable(username);
        return orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
    }

    public OrderResponseDto addArticleInOrder(Long id, HttpServletRequest request) {
        OrderResponseDto dto = orderService.addNewOrderOrReturnLastUncompleted(request);
        Order order = orderService.dtoToEntity(dto);
        Article article = articleService.getArticleById(id);

        order.getArticles().add(article);
        orderService.save(order);

        article.setAmount(article.getAmount() - 1);
        articleService.save(article);
        return orderService.entityToDto(order);
    }

    public OrderResponseDto deleteArticleInOrder(Long id, HttpServletRequest request) {
        OrderResponseDto dto = orderService.addNewOrderOrReturnLastUncompleted(request);
        Order order = orderService.dtoToEntity(dto);
        Article article = articleService.getArticleById(id);

        order.getArticles().remove(article);
        orderService.save(order);

        article.setAmount(article.getAmount() + 1);
        articleService.save(article);
        return orderService.entityToDto(order);
    }
}
