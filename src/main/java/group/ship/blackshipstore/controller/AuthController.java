package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.security.AuthResponseDTO;
import group.ship.blackshipstore.dto.security.LoginDTO;
import group.ship.blackshipstore.dto.security.RegisterDTO;
import group.ship.blackshipstore.sevices.security.AuthenticationService;
import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Controller", description = "Controller to register and login")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    @Operation(summary = "Register", description = "Register new Pirate, require name, login, password")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        if (authenticationService.checkExist(registerDTO.getUsername())){
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }
        authenticationService.register(registerDTO);
        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }

    @PostMapping("/login")
    @Operation(summary = "Login", description = "Login, require username, password, return JWT Token")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        String token = authenticationService.login(loginDTO);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

    /*
    Base passwords didn't work (not encrypted)
    Method for update ur password
    Send ur login and desired password as JSON
     */
    @PostMapping("/updatePassword")
    @Hidden
    @PreAuthorize("hasAuthority('Капитан')")
    public ResponseEntity<String> updatePassword(@RequestBody LoginDTO loginDTO){
        if (!authenticationService.checkExist(loginDTO.getUsername())){
            return new ResponseEntity<>("Incorrect username", HttpStatus.BAD_REQUEST);
        }
        authenticationService.updatePassword(loginDTO);
        return new ResponseEntity<>("Successfully update", HttpStatus.OK);
    }
}
