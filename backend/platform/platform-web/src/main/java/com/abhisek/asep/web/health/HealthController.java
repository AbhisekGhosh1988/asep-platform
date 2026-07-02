package com.abhisek.asep.web.health;

import com.abhisek.asep.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/health")
public class HealthController {

    @Value("${spring.application.name}")
    private String applicationName;

    @GetMapping
    public ApiResponse<HealthResponse> health() {

        HealthResponse response = new HealthResponse(applicationName, "UP", Instant.now());
        return ApiResponse.success(response);
    }
}