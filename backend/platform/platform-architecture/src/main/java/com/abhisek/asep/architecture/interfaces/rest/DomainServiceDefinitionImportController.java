package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.request.DomainServiceDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.domainservice.imports.dto.response.DomainServiceDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.domainservice.imports.service.DomainServiceDefinitionImportService;
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
@RequestMapping("/api/v1/design/domain-services")
@RequiredArgsConstructor
@Tag(name = "Domain Service Import")
public class DomainServiceDefinitionImportController extends BaseController {

    private final DomainServiceDefinitionImportService service;

    @Operation(summary = "Import Domain Service")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<DomainServiceDefinitionImportResponse>>
    importDomainService(@Valid @RequestBody DomainServiceDefinitionImportRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Domain Service imported successfully.", service.importDomainService(request)));

    }

}