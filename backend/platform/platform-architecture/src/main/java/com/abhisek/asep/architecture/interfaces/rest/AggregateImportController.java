package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.imports.dto.request.AggregateImportRequest;
import com.abhisek.asep.architecture.application.design.imports.dto.response.AggregateImportResponse;
import com.abhisek.asep.architecture.application.design.imports.service.AggregateImportService;
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
@RequestMapping("/api/v1/design/aggregates")
@RequiredArgsConstructor
@Tag(name = "Aggregate Import")
public class AggregateImportController extends BaseController {

    private final AggregateImportService service;

    @Operation(summary = "Import Aggregate")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<AggregateImportResponse>> importAggregate(

            @Valid @RequestBody AggregateImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Aggregate imported successfully.", service.importAggregate(request)));

    }

}