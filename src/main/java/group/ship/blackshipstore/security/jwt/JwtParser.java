package group.ship.blackshipstore.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtParser {

    private final JwtGenerator jwtGenerator;

    @Autowired
    public JwtParser(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    private final static String AUTHORIZATION_HEADER_NAME = "authorization";

    //TODO make custom exception for parse token

    public String parseUsernameFromRequest(HttpServletRequest request){
        String authorizationToken = request.getHeader(AUTHORIZATION_HEADER_NAME);
        String token = authorizationToken.replace("Bearer ", "");
        String username = jwtGenerator.gerUsernameFromJWT(token);
        return username;
    }

}
