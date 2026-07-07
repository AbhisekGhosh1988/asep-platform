package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.valueobject.ai.dto.ValueObjectDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.valueobject.service.ValueObjectDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/value-objects")
@RequiredArgsConstructor
@Tag(name = "Value Object Discovery")
public class ValueObjectDiscoveryController {

    private final ValueObjectDiscoveryService discoveryService;

    @Operation(summary = "Discover Value Objects")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<ValueObjectDiscoveryResponse>> discover(@PathVariable("aggregateId")
                                                                                  String aggregateId) {
        return ResponseEntity.ok(ApiResponse.success("Value Objects discovered successfully.",
                discoveryService.discover(aggregateId)));

    }
}