package com.abhisek.asep.web.info;

import com.abhisek.asep.common.response.ApiResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringBootVersion;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;

@RestController
@RequestMapping("/api/v1/info")
public class BuildInfoController {

    @Value("${spring.application.name}")
    private String application;

    @Value("${application.version}")
    private String version;

    @GetMapping
    public ApiResponse<BuildInfoResponse> info() {

        return ApiResponse.success(new BuildInfoResponse(application, version, System.getProperty("java.version"), SpringBootVersion.getVersion(), Instant.now()));
    }
}