package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.specification.ai.dto.SpecificationDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.specification.service.SpecificationDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/specifications")
@RequiredArgsConstructor
@Tag(name = "Specification Discovery")
public class SpecificationDefinitionDiscoveryController extends BaseController {

    private final SpecificationDefinitionDiscoveryService service;

    @Operation(summary = "Discover Specifications")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<SpecificationDefinitionDiscoveryResponse>> discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Specifications discovered successfully.", service.discover(aggregateId)));

    }

}