package infra;

import infra.exception.NotFoundUserException;
import infra.exception.UnauthorizedException;
import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.NonUniqueResultException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> error404(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(UnauthorizedException.class)
    public ResponseEntity<Void> error401(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler({
            NotFoundUserException.class,
            NonUniqueResultException.class,
    })
    public ResponseEntity<Void> error400(){
        return ResponseEntity.badRequest().build();
    }

}
