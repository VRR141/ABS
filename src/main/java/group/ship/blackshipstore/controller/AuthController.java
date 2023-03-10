package group.ship.blackshipstore.controller;

import group.ship.blackshipstore.dto.security_dto.AuthResponseDTO;
import group.ship.blackshipstore.dto.security_dto.LoginDTO;
import group.ship.blackshipstore.dto.security_dto.RegisterDTO;
import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.entity.Role;
import group.ship.blackshipstore.security.JwtGenerator;
import group.ship.blackshipstore.sevices.PirateService;
import group.ship.blackshipstore.sevices.RoleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

@RestController
@RequestMapping("/auth")
@Tag(name = "Authentication Controller", description = "Controller to register and login")
public class AuthController {

    private AuthenticationManager authenticationManager;
    private PirateService pirateService;
    private RoleService roleService;
    private PasswordEncoder passwordEncoder;
    private JwtGenerator jwtGenerator;

    @Autowired
    public AuthController(
            AuthenticationManager authenticationManager,
            PirateService pirateService,
            RoleService roleService,
            PasswordEncoder passwordEncoder,
            JwtGenerator jwtGenerator) {
        this.authenticationManager = authenticationManager;
        this.pirateService = pirateService;
        this.roleService = roleService;
        this.passwordEncoder = passwordEncoder;
        this.jwtGenerator = jwtGenerator;
    }

    @PostMapping("register")
    @Operation(summary = "Register", description = "Register new Pirate, require name, login, password")
    public ResponseEntity<String> register(@RequestBody RegisterDTO registerDTO){
        if (pirateService.existsByUsername(registerDTO.getUsername())){
            return new ResponseEntity<>("Username is taken", HttpStatus.BAD_REQUEST);
        }

        Pirate pirate = new Pirate();
        pirate.setName(registerDTO.getName());
        pirate.setUsername(registerDTO.getUsername());
        pirate.setPassword(passwordEncoder.encode(registerDTO.getPassword()));

        Role role = roleService.findByName("USER").get();
        pirate.setRoles(Collections.singletonList(role));

        this.pirateService.save(pirate);
        return new ResponseEntity<>("User registered success", HttpStatus.OK);
    }

    @PostMapping("login")
    @Operation(summary = "Login", description = "Login, require username, password, return JWT Token")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody LoginDTO loginDTO){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return new ResponseEntity<>(new AuthResponseDTO(token), HttpStatus.OK);
    }

}
