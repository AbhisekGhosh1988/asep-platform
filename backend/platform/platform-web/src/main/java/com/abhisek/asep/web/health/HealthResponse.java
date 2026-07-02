package com.abhisek.asep.web.health;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class HealthResponse {

    private String application;
    private String status;
    private Instant timestamp;

}