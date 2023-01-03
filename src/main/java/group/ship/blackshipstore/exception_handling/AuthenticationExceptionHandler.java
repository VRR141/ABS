package group.ship.blackshipstore.exception_handling;

import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationCredentialsNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AuthenticationExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(AuthenticationCredentialsNotFoundException.class)
    public ResponseEntity<BadJwtToken> handleException(AuthenticationCredentialsNotFoundException e){
        BadJwtToken badJwtToken = new BadJwtToken();
        badJwtToken.setInfo(e.getMessage());
        return new ResponseEntity<>(badJwtToken, HttpStatus.UNAUTHORIZED);
    }
}
