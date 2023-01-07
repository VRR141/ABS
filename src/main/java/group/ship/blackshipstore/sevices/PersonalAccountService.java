package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Article;
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

    @Autowired
    public PersonalAccountService(OrderService orderService,
                                  JwtParser jwtParser,
                                  PirateService pirateService) {
        this.orderService = orderService;
        this.jwtParser = jwtParser;
        this.pirateService = pirateService;
    }

    public List<OrderResponseDto> getSelfOrders(HttpServletRequest request){
        String username = jwtParser.parseUsernameFromRequest(request);
        Long id = pirateService.findByUsername(username).orElseThrow().getId();
        return orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
    }

    public OrderResponseDto addArticleInOrder(Article article, Long id) {
        return orderService.addArticleInOrder(article, id);
    }

    public OrderResponseDto deleteArticleInOrder(Article article, Long id) {
        return orderService.deleteArticleInOrder(article, id);
    }
}
