package com.abhisek.asep.core.web.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.time.Instant;
import java.util.List;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiError {

    private Instant timestamp;

    private int status;

    private String error;

    private String message;

    private String path;

    private List<String> details;

}