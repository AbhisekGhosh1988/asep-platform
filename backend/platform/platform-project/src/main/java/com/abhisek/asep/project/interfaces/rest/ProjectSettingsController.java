package com.abhisek.asep.project.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.project.application.dto.request.UpdateProjectSettingsRequest;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.usecase.GetProjectSettingsUseCase;
import com.abhisek.asep.project.application.usecase.UpdateProjectSettingsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/settings")
@RequiredArgsConstructor
@Tag(name = "Project Settings", description = "Project Settings APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class ProjectSettingsController extends BaseController {

    private final GetProjectSettingsUseCase getProjectSettingsUseCase;
    private final UpdateProjectSettingsUseCase updateProjectSettingsUseCase;

    @GetMapping
    @Operation(summary = "Get Project Settings")
    public ResponseEntity<ApiResponse<ProjectSettingsResponse>> getSettings(@PathVariable String projectId) {

        return ok("Project settings retrieved successfully", getProjectSettingsUseCase.execute(projectId));
    }

    @PutMapping
    @Operation(summary = "Update Project Settings")
    public ResponseEntity<ApiResponse<ProjectSettingsResponse>> updateSettings(@PathVariable String projectId, @Valid @RequestBody UpdateProjectSettingsRequest request) {

        return ok("Project settings updated successfully", updateProjectSettingsUseCase.execute(projectId, request));
    }
}