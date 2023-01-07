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

    private OrderService orderService;

    private JwtParser jwtParser;

    private PirateService pirateService;

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
        Long id = pirateService.findByUsername(username).get().getId();
        List<OrderResponseDto> result = orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
        return result;
    }

    public OrderResponseDto addArticleInOrder(Article article, Long id) {
        return orderService.addArticleInOrder(article, id);
    }

    public OrderResponseDto deleteArticleInOrder(Article article, Long id) {
        return orderService.deleteArticleInOrder(article, id);
    }
}
