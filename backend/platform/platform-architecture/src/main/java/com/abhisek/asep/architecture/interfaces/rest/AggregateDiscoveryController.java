package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.ai.dto.AggregateDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.service.AggregateDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design")
@RequiredArgsConstructor
@Tag(name = "Design Discovery")
public class AggregateDiscoveryController extends BaseController {

    private final AggregateDiscoveryService discoveryService;

    @Operation(summary = "Discover Aggregates")
    @PostMapping("/aggregates/discover/{architectureId}")
    public ResponseEntity<ApiResponse<AggregateDiscoveryResponse>> discover(
            @PathVariable("architectureId") String architectureId) {

        return ResponseEntity.ok(ApiResponse.success("Aggregates discovered successfully.", discoveryService.discover(architectureId)));

    }

}