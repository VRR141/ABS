package group.ship.blackshipstore.exception_handling;

import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@Order(Ordered.HIGHEST_PRECEDENCE)
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = AuthenticationException.class)
    public ResponseEntity<BadJwtToken> handleException(AuthenticationException e){
        BadJwtToken badJwtToken = new BadJwtToken();
        badJwtToken.setInfo(e.getMessage());
        return new ResponseEntity<>(badJwtToken, HttpStatus.UNAUTHORIZED);
    }
}
