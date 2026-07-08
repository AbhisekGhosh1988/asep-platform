package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.apicontract.ai.dto.ApiContractDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.apicontract.service.ApiContractDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/api-contracts")
@RequiredArgsConstructor
@Tag(name = "API Contract Discovery")
public class ApiContractDiscoveryController extends BaseController {

    private final ApiContractDiscoveryService service;

    @Operation(summary = "Discover API Contracts")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<ApiContractDiscoveryResponse>> discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("API Contracts discovered successfully.", service.discover(aggregateId)));

    }

}