package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.CreatePermissionRequest;
import com.abhisek.asep.identity.application.dto.response.PermissionResponse;
import com.abhisek.asep.identity.application.service.PermissionService;
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
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
@Tag(name = "Permission Management", description = "Manage permissions")
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    @Operation(summary = "Create Permission", description = "Creates a new application permission.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Permission created"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Permission already exists")})
    public ResponseEntity<ApiResponse<PermissionResponse>> create(@Valid @RequestBody CreatePermissionRequest request) {

        return ResponseEntity.status(HttpStatus.CREATED).body(ApiResponse.success("Permission created successfully", permissionService.create(request)));
    }

    @Operation(summary = "List Permission", description = "Returns all Permission.")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionResponse>>> findAll() {

        return ResponseEntity.ok(ApiResponse.success("Permissions retrieved successfully", permissionService.findAll()));
    }

    @Operation(summary = "Find Permission", description = "Returns Permission by id.")
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionResponse>> findById(@PathVariable String id) {

        return ResponseEntity.ok(ApiResponse.success("Permission retrieved successfully", permissionService.findById(id)));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Permission", description = "Deletes a Permission.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<Void> delete(@PathVariable String id) {

        permissionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}