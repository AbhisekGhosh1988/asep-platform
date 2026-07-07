package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.request.DomainEventDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainevent.imports.dto.response.DomainEventDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.domainevent.imports.service.DomainEventDefinitionImportService;
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
@RequestMapping("/api/v1/design/domain-events")
@RequiredArgsConstructor
@Tag(name = "Domain Event Import")
public class DomainEventDefinitionImportController extends BaseController {

    private final DomainEventDefinitionImportService service;

    @Operation(summary = "Import Domain Event")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<DomainEventDefinitionImportResponse>> importDomainEvent(@Valid @RequestBody DomainEventDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Domain Event imported successfully.", service.importDomainEvent(request)));

    }

}