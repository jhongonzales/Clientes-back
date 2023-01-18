package com.company.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.stream.Collectors;

@RestControllerAdvice
public class ApiExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ModelNotFoundException.class)
    public ResponseEntity<ExceptionResponse> manejarModelNotFoundException(ModelNotFoundException ex, WebRequest req){
        ExceptionResponse e = new ExceptionResponse(ex.getMessage(), req.getDescription(false), LocalDateTime.now());
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        String message = ex.getBindingResult().getAllErrors().stream().map(e -> {
            return Objects.requireNonNull(e.getDefaultMessage()).concat(", ");
        }).collect(Collectors.joining());

        ExceptionResponse e = new ExceptionResponse(message, request.getDescription(false), LocalDateTime.now());

        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
