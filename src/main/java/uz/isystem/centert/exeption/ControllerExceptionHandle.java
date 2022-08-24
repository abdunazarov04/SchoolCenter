package uz.isystem.centert.exeption;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import uz.isystem.centert.util.Response;

import java.time.LocalDateTime;
import java.util.Map;

@ControllerAdvice
public class ControllerExceptionHandle {
    @ExceptionHandler({ServerBadRequestException.class})
    public ResponseEntity<?> handlerException(ServerBadRequestException e){
        Response response = new Response();
        response.setData(Map.of("Error", e.getMessage()));
        response.setTimeStep(LocalDateTime.now());
        response.setStatus(HttpStatus.BAD_REQUEST);
        response.setStatusCode(HttpStatus.BAD_REQUEST.value());
        return ResponseEntity.badRequest().body(response);
    }
}

