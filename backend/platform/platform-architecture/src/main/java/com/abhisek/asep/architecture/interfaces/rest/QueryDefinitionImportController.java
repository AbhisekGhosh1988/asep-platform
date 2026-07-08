package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.query.imports.dto.request.QueryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.query.imports.dto.response.QueryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.query.imports.service.QueryDefinitionImportService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/queries")
@RequiredArgsConstructor
@Tag(name = "Query Definition Import")
public class QueryDefinitionImportController {

    private final QueryDefinitionImportService service;

    @Operation(summary = "Import Query Definition")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<QueryDefinitionImportResponse>>
    importQueryDefinition(@Valid @RequestBody QueryDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).
                body(ApiResponse.success("Query Definition imported successfully.",
                        service.importQueryDefinition(request)));

    }

}