package group.ship.blackshipstore.security;

import group.ship.blackshipstore.dto.security.LoginDTO;
import group.ship.blackshipstore.dto.security.RegisterDTO;
import group.ship.blackshipstore.entity.Pirate;
import group.ship.blackshipstore.entity.Role;
import group.ship.blackshipstore.security.jwt.JwtGenerator;
import group.ship.blackshipstore.sevices.PirateService;
import group.ship.blackshipstore.sevices.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class AuthenticationServiceImpl implements AuthenticationService{

    private PasswordEncoder passwordEncoder;

    private RoleService roleService;

    private PirateService pirateService;

    private AuthenticationManager authenticationManager;

    private JwtGenerator jwtGenerator;

    private final String defaultRole = "Пират";

    @Autowired
    public AuthenticationServiceImpl(
            PasswordEncoder passwordEncoder,
            RoleService roleService,
            PirateService pirateService,
            AuthenticationManager authenticationManager,
            JwtGenerator jwtGenerator) {
        this.passwordEncoder = passwordEncoder;
        this.roleService = roleService;
        this.pirateService = pirateService;
        this.authenticationManager = authenticationManager;
        this.jwtGenerator = jwtGenerator;
    }

    @Override
    public boolean register(RegisterDTO registerDTO) {
        Pirate pirate = new Pirate();
        pirate.setName(registerDTO.getName());
        pirate.setUsername(registerDTO.getUsername());
        pirate.setPassword(passwordEncoder.encode(registerDTO.getPassword()));
        Role role = roleService.findByName(defaultRole).get();
        pirate.setRoles(Collections.singletonList(role));
        pirateService.save(pirate);
        return true;
    }

    @Override
    public boolean checkExist(RegisterDTO registerDTO) {
        return pirateService.existsByUsername(registerDTO.getUsername());
    }

    public boolean checkExist(LoginDTO loginDTO) {
        return pirateService.existsByUsername(loginDTO.getUsername());
    }

    @Override
    public String login(LoginDTO loginDTO) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        loginDTO.getUsername(),
                        loginDTO.getPassword()));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        String token = jwtGenerator.generateToken(authentication);
        return token;
    }

    @Override
    public void updatePassword(LoginDTO loginDTO) {
        Pirate pirate = pirateService.findByUsername(loginDTO.getUsername()).get();
        pirate.setPassword(passwordEncoder.encode(loginDTO.getPassword()));
        pirateService.save(pirate);
    }
}
