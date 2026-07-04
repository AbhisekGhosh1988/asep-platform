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

        HttpStatus status = switch (ex.getErrorCode()) {

            case USER_NOT_FOUND, ROLE_NOT_FOUND, PERMISSION_NOT_FOUND, RESOURCE_NOT_FOUND, REFRESH_TOKEN_NOT_FOUND ->
                    HttpStatus.NOT_FOUND;

            case USER_ALREADY_EXISTS, EMAIL_ALREADY_EXISTS, CONFLICT -> HttpStatus.CONFLICT;

            case INVALID_CREDENTIALS, TOKEN_INVALID, TOKEN_EXPIRED, UNAUTHORIZED -> HttpStatus.UNAUTHORIZED;

            case FORBIDDEN -> HttpStatus.FORBIDDEN;

            case VALIDATION_FAILED, INVALID_REQUEST, BAD_REQUEST -> HttpStatus.BAD_REQUEST;

            default -> HttpStatus.INTERNAL_SERVER_ERROR;
        };

        ErrorResponse response = new ErrorResponse(Instant.now(), ex.getErrorCode().getCode(), ex.getMessage(), request.getRequestURI(), List.of());

        return ResponseEntity.status(status).body(response);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex, HttpServletRequest request) {

        List<ValidationError> errors = ex.getBindingResult().getFieldErrors().stream().map(field -> new ValidationError(field.getField(), field.getDefaultMessage())).toList();
        ErrorResponse response = new ErrorResponse(Instant.now(), "VALIDATION_ERROR", "Validation failed", request.getRequestURI(), errors);

        return ResponseEntity.badRequest().body(response);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception ex, HttpServletRequest request) {

        ErrorResponse response = new ErrorResponse(Instant.now(), "INTERNAL_SERVER_ERROR", ex.getMessage(), request.getRequestURI(), List.of());

        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(response);
    }
}