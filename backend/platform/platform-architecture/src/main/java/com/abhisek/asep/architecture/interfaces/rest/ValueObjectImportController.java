package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.request.ValueObjectImportRequest;
import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.response.ValueObjectImportResponse;
import com.abhisek.asep.architecture.application.design.valueobject.imports.service.ValueObjectImportService;
import com.abhisek.asep.common.response.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/design/value-objects")
@RequiredArgsConstructor
@Tag(name = "Value Object Import")
public class ValueObjectImportController {

    private final ValueObjectImportService service;

    @Operation(summary = "Import Value Object")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<ValueObjectImportResponse>>
    importValueObject(@Valid @RequestBody ValueObjectImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).
                body(ApiResponse.success("Value Object imported successfully.",
                        service.importValueObject(request)));

    }

}