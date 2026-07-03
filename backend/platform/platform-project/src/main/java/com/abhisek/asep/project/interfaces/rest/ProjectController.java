package com.abhisek.asep.project.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.usecase.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects")
@RequiredArgsConstructor
@Tag(name = "Project Management", description = "Project Management APIs")
public class ProjectController {

    private final CreateProjectUseCase createProjectUseCase;
    private final GetProjectUseCase getProjectUseCase;
    private final ListProjectsUseCase listProjectsUseCase;
    private final UpdateProjectUseCase updateProjectUseCase;
    private final DeleteProjectUseCase deleteProjectUseCase;

    @PostMapping
    @Operation(summary = "Create Project", description = "Creates a new ASEP project.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Project created successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Project already exists")})
    public ResponseEntity<ApiResponse<ProjectResponse>> create(

            @Valid @RequestBody CreateProjectRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Project created successfully", createProjectUseCase.execute(request)));

    }
    @Operation(summary = "Get Project", description = "Get project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project retrieved successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Project not found")})
    @GetMapping("/{id}")
    public ApiResponse<ProjectResponse> get(@PathVariable String id) {
        return ApiResponse.success("Project retrieved successfully", getProjectUseCase.execute(id));
    }

    @GetMapping
    @Operation(summary = "Get Projects", description = "Get all projects")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "All Project retrieved successfully"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "No projects found")})
    public ApiResponse<List<ProjectResponse>> list() {
        return ApiResponse.success("Projects retrieved successfully", listProjectsUseCase.execute());
    }

    @PutMapping("/{id}")
    @Operation(summary = "Update Project", description = "Update project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "200", description = "Project updated successfully")})
    public ApiResponse<ProjectResponse> update(@PathVariable String id, @Valid @RequestBody UpdateProjectRequest request) {

        return ApiResponse.success("Project updated successfully", updateProjectUseCase.execute(id, request));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Project", description = "Delete project by Id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "204", description = "Project retrieved successfully")})
    public ApiResponse<Void> delete(@PathVariable String id) {

        deleteProjectUseCase.execute(id);

        return ApiResponse.success("Project deleted successfully", null);
    }


}