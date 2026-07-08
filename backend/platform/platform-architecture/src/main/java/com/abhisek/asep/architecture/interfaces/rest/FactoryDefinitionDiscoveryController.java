package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.factory.ai.dto.FactoryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.factory.service.FactoryDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/factories")
@RequiredArgsConstructor
@Tag(name = "Factory Discovery")
public class FactoryDefinitionDiscoveryController {

    private final FactoryDefinitionDiscoveryService service;

    @Operation(summary = "Discover Factories")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<FactoryDefinitionDiscoveryResponse>>
    discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Factories discovered successfully.",
                service.discover(aggregateId)));

    }

}