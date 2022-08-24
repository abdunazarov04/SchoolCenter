package uz.isystem.centert.exeption;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.*;
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ResponseEntity<?> exception(ServerBadRequestException e){
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
