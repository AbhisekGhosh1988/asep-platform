package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.specification.imports.dto.request.SpecificationDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.specification.imports.dto.response.SpecificationDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.specification.imports.service.SpecificationDefinitionImportService;
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
@RequestMapping("/api/v1/design/specifications")
@RequiredArgsConstructor
@Tag(name = "Specification Import")
public class SpecificationDefinitionImportController extends BaseController {

    private final SpecificationDefinitionImportService service;

    @Operation(summary = "Import Specification")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<SpecificationDefinitionImportResponse>> importSpecification(@Valid @RequestBody SpecificationDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Specification imported successfully.", service.importSpecification(request)));

    }

}