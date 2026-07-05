package com.abhisek.asep.project.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.project.application.dto.request.AddProjectMemberRequest;
import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.application.usecase.AddProjectMemberUseCase;
import com.abhisek.asep.project.application.usecase.ListProjectMembersUseCase;
import com.abhisek.asep.project.application.usecase.RemoveProjectMemberUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/projects/{projectId}/members")
@RequiredArgsConstructor
@Tag(name = "Project Members", description = "Project member management APIs")
@SecurityRequirement(name = "Bearer Authentication")
public class ProjectMemberController extends BaseController {

    private final AddProjectMemberUseCase addProjectMemberUseCase;
    private final ListProjectMembersUseCase listProjectMembersUseCase;
    private final RemoveProjectMemberUseCase removeProjectMemberUseCase;

    @PostMapping
    @Operation(summary = "Add Project Member")
    public ResponseEntity<ApiResponse<ProjectMemberResponse>> addMember(@PathVariable String projectId, @Valid @RequestBody AddProjectMemberRequest request) {

        return created("Project member added successfully", addProjectMemberUseCase.execute(projectId, request));
    }

    @GetMapping
    @Operation(summary = "List Project Members")
    public ResponseEntity<ApiResponse<List<ProjectMemberResponse>>> listMembers(@PathVariable String projectId) {

        return ok("Project members retrieved successfully", listProjectMembersUseCase.execute(projectId));
    }

    @DeleteMapping("/{userId}")
    @Operation(summary = "Remove Project Member")
    public ResponseEntity<ApiResponse<Void>> removeMember(@PathVariable String projectId, @PathVariable String userId) {

        removeProjectMemberUseCase.execute(projectId, userId);
        return deleted("Project member removed successfully");
    }
}