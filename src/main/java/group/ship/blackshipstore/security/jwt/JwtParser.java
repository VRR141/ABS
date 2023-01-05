package group.ship.blackshipstore.security.jwt;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class JwtParser {

    private JwtGenerator jwtGenerator;

    @Autowired
    public JwtParser(JwtGenerator jwtGenerator) {
        this.jwtGenerator = jwtGenerator;
    }

    private final static String AUTHORIZATION_HEADER_NAME = "authorization";

    //TODO make custom exception for parse token

    public String parseUsernameFromRequest(HttpServletRequest request){
        String authorizationToken = request.getHeader(AUTHORIZATION_HEADER_NAME);
        String[] parts = authorizationToken.split(" ");
        if (parts.length > 2) {
            throw new RuntimeException("incorrect authentication token");
        }
        String token = parts[1];
        String username = jwtGenerator.gerUsernameFromJWT(token);
        return username;
    }

}
