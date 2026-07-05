package com.abhisek.asep.project.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.request.ProjectActionRequest;
import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "Project Management", description = "Project Management APIs")
public class ProjectController extends BaseController {

    private final CreateProjectUseCase createProjectUseCase;
    private final GetProjectUseCase getProjectUseCase;
    private final ListProjectsUseCase listProjectsUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;
    private final ExecuteProjectActionUseCase executeProjectActionUseCase;

    @PostMapping
    @Operation(summary = "Create Project", description = "Creates a new ASEP project.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Project created successfully"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Project already exists")})
    public ResponseEntity<ApiResponse<ProjectResponse>> create(@Valid @RequestBody CreateProjectRequest request) {

        return created("Project created successfully", createProjectUseCase.execute(request));
    }

    @GetMapping("/{id}")
    @Operation(summary = "Get Project", description = "Get project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project retrieved successfully"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Project not found")})
    public ResponseEntity<ApiResponse<ProjectResponse>> get(@PathVariable String id) {

        return ok("Project retrieved successfully", getProjectUseCase.execute(id));
    }

    @GetMapping
    @Operation(summary = "Get Projects", description = "Get all projects")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "All Project retrieved successfully"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "No projects found")})
    public ResponseEntity<ApiResponse<List<ProjectResponse>>> list() {

        return ok("Projects retrieved successfully", listProjectsUseCase.execute());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Project", description = "Update project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project updated successfully")})
    public ResponseEntity<ApiResponse<ProjectResponse>> update(@PathVariable String id, @Valid @RequestBody UpdateProjectRequest request) {

        return ok("Project updated successfully", updateProjectUseCase.execute(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Project", description = "Delete project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Project deleted successfully")})
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id) {

        deleteProjectUseCase.execute(id);
        return deleted("Project deleted successfully");
    }

    @PostMapping("/{id}/actions")
    @Operation(summary = "Execute Project Action", description = "Executes lifecycle actions on a project.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<ProjectResponse>> executeAction(@PathVariable String id, @Valid @RequestBody ProjectActionRequest request) {

        return ok("Project action executed successfully", executeProjectActionUseCase.execute(id, request));
    }
}