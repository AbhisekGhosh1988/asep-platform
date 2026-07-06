package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.imports.dto.request.ArchitectureImportRequest;
import com.abhisek.asep.architecture.application.imports.dto.response.ArchitectureImportResponse;
import com.abhisek.asep.architecture.application.imports.service.ArchitectureImportService;
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
@RequestMapping("/api/v1/architectures")
@RequiredArgsConstructor
@Tag(name = "Architecture Import", description = "Imports an approved AI generated architecture.")
public class ArchitectureImportController extends BaseController {

    private final ArchitectureImportService architectureImportService;

    @Operation(summary = "Import Architecture")
    @PostMapping("/import")
    public ResponseEntity<ApiResponse<ArchitectureImportResponse>> importArchitecture(

            @Valid @RequestBody ArchitectureImportRequest request) {

        ArchitectureImportResponse response = architectureImportService.importArchitecture(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Architecture imported successfully.", response));

    }

}