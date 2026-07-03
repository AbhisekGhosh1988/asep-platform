package com.abhisek.asep.web.advice;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {

    private Instant timestamp;
    private String code;
    private String message;
    private String path;

    /**
     * Validation or business errors.
     */
    private List<?> errors;

}