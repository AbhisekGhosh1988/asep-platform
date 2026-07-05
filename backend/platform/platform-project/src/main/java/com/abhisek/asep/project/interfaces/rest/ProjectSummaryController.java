package com.abhisek.asep.project.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.project.application.dto.response.ProjectSummaryResponse;
import com.abhisek.asep.project.application.usecase.GetProjectSummaryUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "Project Summary", description = "Project Summary APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class ProjectSummaryController extends BaseController {

    private final GetProjectSummaryUseCase useCase;

    @GetMapping("/{projectId}/summary")
    @Operation(summary = "Get Project Summary", description = "Returns project overview with statistics.")
    public ResponseEntity<ApiResponse<ProjectSummaryResponse>> summary(@PathVariable String projectId) {

        return ok("Project summary retrieved successfully", useCase.execute(projectId));
    }
}