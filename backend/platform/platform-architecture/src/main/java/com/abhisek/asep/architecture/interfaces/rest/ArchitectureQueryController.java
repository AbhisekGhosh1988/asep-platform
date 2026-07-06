package com.abhisek.asep.architecture.interfaces.rest;

import com.abhisek.asep.architecture.application.query.dto.ArchitectureDetailsResponse;
import com.abhisek.asep.architecture.application.query.service.ArchitectureQueryService;
import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/architectures")
@RequiredArgsConstructor
@Tag(name = "Architecture Query", description = "Architecture Query APIs")
public class ArchitectureQueryController extends BaseController {

    private final ArchitectureQueryService queryService;

    @Operation(summary = "Get Architecture Details")
    @GetMapping("/{architectureId}/details")
    public ResponseEntity<ApiResponse<ArchitectureDetailsResponse>> getArchitecture(
            @PathVariable("architectureId") String architectureId) {

        return ResponseEntity.ok(ApiResponse.success("Architecture loaded successfully.",
                queryService.getArchitecture(architectureId)));

    }

}