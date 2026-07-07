package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.entity.imports.dto.request.EntityImportRequest;
import com.abhisek.asep.architecture.application.design.entity.imports.dto.response.EntityImportResponse;
import com.abhisek.asep.architecture.application.design.entity.imports.service.EntityImportService;
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
@RequestMapping("/api/v1/design/entities")
@RequiredArgsConstructor
@Tag(name = "Entity Import")
public class EntityImportController extends BaseController {

    private final EntityImportService service;

    @Operation(summary = "Import Entity")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<EntityImportResponse>> importEntity(

            @Valid @RequestBody EntityImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Entity imported successfully.", service.importEntity(request)));

    }

}