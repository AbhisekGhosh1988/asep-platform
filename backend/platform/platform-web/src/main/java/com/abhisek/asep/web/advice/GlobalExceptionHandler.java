package com.abhisek.asep.web.advice;

import com.abhisek.asep.common.exception.ASEPException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.Instant;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ASEPException.class)
    public ResponseEntity<ErrorResponse> handleASEPException(ASEPException ex, HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse(Instant.now(), ex.getErrorCode().getCode(),
                ex.getMessage(), request.getRequestURI(), List.of());

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,
                                                          HttpServletRequest request) {

        List<String> errors = ex.getBindingResult().getFieldErrors().stream().
                map(FieldError::getDefaultMessage).toList();

        ErrorResponse response = new ErrorResponse(Instant.now(), "VALIDATION_ERROR",
                "Validation failed", request.getRequestURI(), errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse(Instant.now(), "INTERNAL_SERVER_ERROR",
                ex.getMessage(), request.getRequestURI(), List.of());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}