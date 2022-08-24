package uz.isystem.s.students.util;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Response {
    private LocalDateTime timeStep;
    private Integer statusCode;
    private HttpStatus status;
    private String reason;
    private String message;
    private String developerMessage;
    private Map<?,?> data;
}
