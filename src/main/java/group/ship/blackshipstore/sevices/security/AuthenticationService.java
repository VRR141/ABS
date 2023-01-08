package group.ship.blackshipstore.sevices.security;

import group.ship.blackshipstore.dto.security.LoginDTO;
import group.ship.blackshipstore.dto.security.RegisterDTO;

public interface AuthenticationService {

    boolean register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);

    boolean checkExist(String login);

    void updatePassword(LoginDTO loginDTO);
}
