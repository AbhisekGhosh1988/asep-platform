package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.relationship.imports.dto.request.RelationshipImportRequest;
import com.abhisek.asep.architecture.application.design.relationship.imports.dto.response.RelationshipImportResponse;
import com.abhisek.asep.architecture.application.design.relationship.imports.service.RelationshipImportService;
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
@RequestMapping("/api/v1/design/relationships")
@RequiredArgsConstructor
@Tag(name = "Relationship Import")
public class RelationshipImportController extends BaseController {

    private final RelationshipImportService service;

    @Operation(summary = "Import Relationship")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<RelationshipImportResponse>> importRelationship(@Valid @RequestBody RelationshipImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Relationship imported successfully.", service.importRelationship(request)));
    }
}