package br.com.cruzeirodosul.easyevent.exception.handler;

import br.com.cruzeirodosul.easyevent.exception.custom.EntityNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@RestControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private static final String ERRORS_PROPERTY_NAME = "errors";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, @NonNull HttpHeaders headers, @NonNull HttpStatusCode status, @NonNull WebRequest request) {
        Set<String> errors = new HashSet<>();
        ex.getBindingResult().getFieldErrors().forEach(e -> errors.add(e.getField() + " " + e.getDefaultMessage()));

        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(status, "Invalid request content.");
        problemDetail.setProperty(ERRORS_PROPERTY_NAME, errors);

        log.error(ex.getMessage(), ex);

        return ResponseEntity.status(status).headers(headers).body(problemDetail);
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ProblemDetail> handleKeyRead(RuntimeException ex) {
        ProblemDetail problemDetail = ProblemDetail.forStatusAndDetail(HttpStatus.NOT_FOUND, ex.getMessage());
        log.error(ex.getMessage(), ex);
        return ResponseEntity.status(problemDetail.getStatus()).body(problemDetail);
    }

}
