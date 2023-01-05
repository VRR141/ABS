package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.response.OrderResponseDto;
import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.security.jwt.JwtParser;
import group.ship.blackshipstore.sevices.OrderService;
import group.ship.blackshipstore.sevices.PersonalAccountService;
import group.ship.blackshipstore.sevices.PirateService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/account")
@PreAuthorize("hasAuthority('Пират')")
public class PiratePersonalAccountController {

    private PersonalAccountService accountService;

    @Autowired
    public PiratePersonalAccountController(PersonalAccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/orders")
    public ResponseEntity<List<OrderResponseDto>> getSelfOrders(HttpServletRequest request) {
        List<OrderResponseDto> result = accountService.getSelfOrders(request);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
