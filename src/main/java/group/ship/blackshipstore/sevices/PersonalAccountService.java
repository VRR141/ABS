package group.ship.blackshipstore.sevices;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.security.jwt.JwtParser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
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
        Long id = pirateService.findByUsername(username).get().getId();
        List<OrderResponseDto> result = orderService.getAllOrdersByPirateIdOrderByOrderDate(id);
        return result;
    }
}
