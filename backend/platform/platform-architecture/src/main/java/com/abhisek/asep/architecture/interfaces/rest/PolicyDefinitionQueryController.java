package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.policy.query.dto.PolicyDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.policy.query.service.PolicyDefinitionQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/policies")
@RequiredArgsConstructor
@Tag(name = "Policy Query")
public class PolicyDefinitionQueryController extends BaseController {

    private final PolicyDefinitionQueryService service;

    @Operation(summary = "Get Policy")
    @GetMapping("/{policyId}")
    public ResponseEntity<ApiResponse<PolicyDefinitionDetailsResponse>>
    getPolicy(@PathVariable("policyId") String policyId) {

        return ResponseEntity.ok(ApiResponse.success("Policy loaded successfully.",
                service.getPolicy(policyId)));
    }

    @Operation(summary = "List Policies")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<PolicyDefinitionDetailsResponse>>>
    getPolicies(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("Policies loaded successfully.",
                service.getPolicies(aggregateId)));
    }
}