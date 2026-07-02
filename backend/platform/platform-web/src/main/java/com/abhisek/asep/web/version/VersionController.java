package com.abhisek.asep.web.version;

import com.abhisek.asep.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/version")
public class VersionController {

    @Value("${spring.application.name}")
    private String applicationName;

    @Value("${application.version:1.0.0-SNAPSHOT}")
    private String version;

    @GetMapping
    public ApiResponse<VersionResponse> version() {

        VersionResponse response = new VersionResponse(applicationName, version,
                System.getProperty("java.version"), SpringBootVersion.getVersion(), Instant.now());

        return ApiResponse.success(response);
    }
}