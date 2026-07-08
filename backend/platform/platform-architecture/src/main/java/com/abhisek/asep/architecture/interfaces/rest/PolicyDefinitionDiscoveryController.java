package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.policy.ai.dto.PolicyDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.policy.service.PolicyDefinitionDiscoveryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/policies")
@RequiredArgsConstructor
@Tag(name = "Policy Discovery")
public class PolicyDefinitionDiscoveryController extends BaseController {

    private final PolicyDefinitionDiscoveryService service;

    @Operation(summary = "Discover Policies")
    @PostMapping("/discover/{aggregateId}")
    public ResponseEntity<ApiResponse<PolicyDefinitionDiscoveryResponse>> discover(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Policies discovered successfully.", service.discover(aggregateId)));

    }

}