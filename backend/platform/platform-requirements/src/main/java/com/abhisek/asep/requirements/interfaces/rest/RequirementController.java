package com.abhisek.asep.requirements.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.requirements.application.dto.request.ApproveRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.RejectRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;
import com.abhisek.asep.requirements.application.usecase.ApproveRequirementUseCase;
import com.abhisek.asep.requirements.application.usecase.CreateRequirementUseCase;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementUseCase;
import com.abhisek.asep.requirements.application.usecase.GetRequirementUseCase;
import com.abhisek.asep.requirements.application.usecase.ListRequirementsUseCase;
import com.abhisek.asep.requirements.application.usecase.RejectRequirementUseCase;
import com.abhisek.asep.requirements.application.usecase.UpdateRequirementUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
@Tag(name = "Requirement Management", description = "Requirement Management APIs")
public class RequirementController extends BaseController {

    private final CreateRequirementUseCase createRequirementUseCase;
    private final UpdateRequirementUseCase updateRequirementUseCase;
    private final DeleteRequirementUseCase deleteRequirementUseCase;
    private final GetRequirementUseCase getRequirementUseCase;
    private final ListRequirementsUseCase listRequirementsUseCase;
    private final ApproveRequirementUseCase approveRequirementUseCase;
    private final RejectRequirementUseCase rejectRequirementUseCase;

    @PostMapping("/projects/{projectId}/requirements")
    @Operation(summary = "Create Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> create(@PathVariable String projectId, @Valid @RequestBody CreateRequirementRequest request) {

        return created("Requirement created successfully", createRequirementUseCase.execute(projectId, request));
    }

    @PutMapping("/requirements/{id}")
    @Operation(summary = "Update Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> update(@PathVariable String id, @Valid @RequestBody UpdateRequirementRequest request) {

        return ok("Requirement updated successfully", updateRequirementUseCase.execute(id, request));
    }

    @GetMapping("/requirements/{id}")
    @Operation(summary = "Get Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> get(@PathVariable String id) {

        return ok("Requirement retrieved successfully", getRequirementUseCase.execute(id));
    }

    @GetMapping("/projects/{projectId}/requirements")
    @Operation(summary = "List Requirements")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<List<RequirementSummaryResponse>>> list(@PathVariable String projectId) {

        return ok("Requirements retrieved successfully", listRequirementsUseCase.execute(projectId));
    }

    @PostMapping("/requirements/{id}/approve")
    @Operation(summary = "Approve Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> approve(@PathVariable String id, @Valid @RequestBody ApproveRequirementRequest request) {

        return ok("Requirement approved successfully", approveRequirementUseCase.execute(id, request));
    }

    @PostMapping("/requirements/{id}/reject")
    @Operation(summary = "Reject Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RequirementResponse>> reject(@PathVariable String id, @Valid @RequestBody RejectRequirementRequest request) {

        return ok("Requirement rejected successfully", rejectRequirementUseCase.execute(id, request));
    }

    @DeleteMapping("/requirements/{id}")
    @Operation(summary = "Delete Requirement")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id) {

        deleteRequirementUseCase.execute(id);
        return deleted("Requirement deleted successfully");
    }
}