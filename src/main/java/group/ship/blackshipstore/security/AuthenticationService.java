package group.ship.blackshipstore.security;

import group.ship.blackshipstore.dto.security.LoginDTO;
import group.ship.blackshipstore.dto.security.RegisterDTO;

public interface AuthenticationService {

    boolean register(RegisterDTO registerDTO);

    String login(LoginDTO loginDTO);

    boolean checkExist(RegisterDTO registerDTO);

    boolean checkExist(LoginDTO loginDTO);

    void updatePassword(LoginDTO loginDTO);
}
