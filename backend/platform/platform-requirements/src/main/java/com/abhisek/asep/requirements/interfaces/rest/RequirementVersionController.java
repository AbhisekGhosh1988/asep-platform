package com.abhisek.asep.requirements.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;
import com.abhisek.asep.requirements.application.usecase.GetRequirementVersionUseCase;
import com.abhisek.asep.requirements.application.usecase.GetRequirementVersionsUseCase;
import com.abhisek.asep.requirements.application.usecase.RestoreRequirementVersionUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/requirements/{requirementId}/versions")
@RequiredArgsConstructor
@Tag(name = "Requirement Version Management", description = "Requirement Version APIs")
public class RequirementVersionController extends BaseController {

    private final GetRequirementVersionsUseCase getVersionsUseCase;
    private final GetRequirementVersionUseCase getVersionUseCase;
    private final RestoreRequirementVersionUseCase restoreVersionUseCase;

    @GetMapping
    @Operation(summary = "List Versions")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<List<RequirementVersionResponse>>> list(@PathVariable String requirementId) {

        return ok("Versions retrieved successfully", getVersionsUseCase.execute(requirementId));
    }

    @GetMapping("/{version}")
    @Operation(summary = "Get Version")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementVersionResponse>> get(@PathVariable String requirementId, @PathVariable Integer version) {

        return ok("Version retrieved successfully", getVersionUseCase.execute(requirementId, version));
    }

    @PostMapping("/{version}/restore")
    @Operation(summary = "Restore Version")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> restore(@PathVariable String requirementId, @PathVariable Integer version) {

        return ok("Version restored successfully", restoreVersionUseCase.execute(requirementId, version));
    }
}