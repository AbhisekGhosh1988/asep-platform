package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.attribute.imports.dto.request.AttributeImportRequest;
import com.abhisek.asep.architecture.application.design.attribute.imports.dto.response.AttributeImportResponse;
import com.abhisek.asep.architecture.application.design.attribute.imports.service.AttributeImportService;
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
@RequestMapping("/api/v1/design/attributes")
@RequiredArgsConstructor
@Tag(name = "Attribute Import")
public class AttributeImportController extends BaseController {

    private final AttributeImportService service;

    @Operation(summary = "Import Attribute")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<AttributeImportResponse>> importAttribute(

            @Valid @RequestBody AttributeImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Attribute imported successfully.", service.importAttribute(request)));

    }

}