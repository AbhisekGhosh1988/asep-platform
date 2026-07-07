package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.repository.imports.dto.request.RepositoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.repository.imports.dto.response.RepositoryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.repository.imports.service.RepositoryDefinitionImportService;
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
@RequestMapping("/api/v1/design/repositories")
@RequiredArgsConstructor
@Tag(name = "Repository Definition Import")
public class RepositoryDefinitionImportController extends BaseController {

    private final RepositoryDefinitionImportService service;

    @Operation(summary = "Import Repository Definition")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<RepositoryDefinitionImportResponse>> importRepositoryDefinition(@Valid @RequestBody RepositoryDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Repository Definition imported successfully.", service.importRepositoryDefinition(request)));

    }

}