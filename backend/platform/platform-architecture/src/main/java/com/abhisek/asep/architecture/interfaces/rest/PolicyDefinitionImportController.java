package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.policy.imports.dto.request.PolicyDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.policy.imports.dto.response.PolicyDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.policy.imports.service.PolicyDefinitionImportService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/policies")
@RequiredArgsConstructor
@Tag(name = "Policy Import")
public class PolicyDefinitionImportController extends BaseController {

    private final PolicyDefinitionImportService service;

    @Operation(summary = "Import Policy")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<PolicyDefinitionImportResponse>> importPolicy(@Valid @RequestBody PolicyDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Policy imported successfully.", service.importPolicy(request)));
    }
}