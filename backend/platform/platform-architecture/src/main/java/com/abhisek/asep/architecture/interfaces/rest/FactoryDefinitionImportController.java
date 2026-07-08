package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.factory.imports.dto.request.FactoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.factory.imports.dto.response.FactoryDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.factory.imports.service.FactoryDefinitionImportService;
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
@RequestMapping("/api/v1/design/factories")
@RequiredArgsConstructor
@Tag(name = "Factory Import")
public class FactoryDefinitionImportController extends BaseController {

    private final FactoryDefinitionImportService service;

    @Operation(summary = "Import Factory")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<FactoryDefinitionImportResponse>>
    importFactory(@Valid @RequestBody FactoryDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Factory imported successfully.",
                service.importFactory(request)));

    }

}