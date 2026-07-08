package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.request.ApiContractImportRequest;
import com.abhisek.asep.architecture.application.design.apicontract.imports.dto.response.ApiContractImportResponse;
import com.abhisek.asep.architecture.application.design.apicontract.imports.service.ApiContractImportService;
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
@RequestMapping("/api/v1/design/api-contracts")
@RequiredArgsConstructor
@Tag(name = "API Contract Import")
public class ApiContractImportController extends BaseController {

    private final ApiContractImportService service;

    @Operation(summary = "Import API Contract")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<ApiContractImportResponse>> importApiContract(@Valid @RequestBody ApiContractImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("API Contract imported successfully.", service.importApiContract(request)));

    }

}