package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.ai.dto.ArchitectureDiscoveryResponse;
import com.abhisek.asep.architecture.application.ai.service.ArchitectureDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/architectures")
@RequiredArgsConstructor
@Tag(name = "Architecture Discovery", description = "AI powered Architecture Discovery APIs")
public class ArchitectureDiscoveryController extends BaseController {

    private final ArchitectureDiscoveryService discoveryService;

    @Operation(summary = "Discover Architecture")
    @PostMapping("/discover/{projectId}")
    public ResponseEntity<ApiResponse<ArchitectureDiscoveryResponse>> discover(
            @PathVariable("projectId") String projectId) {
        return ResponseEntity.ok(ApiResponse.success("Architecture discovered successfully.",
                discoveryService.discover(projectId)));

    }

}