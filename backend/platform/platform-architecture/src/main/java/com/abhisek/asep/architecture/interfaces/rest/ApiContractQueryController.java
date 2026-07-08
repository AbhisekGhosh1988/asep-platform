package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.application.design.apicontract.query.service.ApiContractQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/design/api-contracts")
@RequiredArgsConstructor
@Tag(name = "API Contract Query")
public class ApiContractQueryController extends BaseController {

    private final ApiContractQueryService service;

    @Operation(summary = "Get API Contract")
    @GetMapping("/{apiContractId}")
    public ResponseEntity<ApiResponse<ApiContractDetailsResponse>> getApiContract(@PathVariable("apiContractId") String apiContractId) {

        return ResponseEntity.ok(ApiResponse.success("API Contract loaded successfully.", service.getApiContract(apiContractId)));

    }

    @Operation(summary = "List API Contracts")
    @GetMapping("/aggregate/{aggregateId}")
    public ResponseEntity<ApiResponse<List<ApiContractDetailsResponse>>> getApiContracts(@PathVariable("aggregateId") String aggregateId) {

        return ResponseEntity.ok(ApiResponse.success("API Contracts loaded successfully.", service.getApiContracts(aggregateId)));

    }

}