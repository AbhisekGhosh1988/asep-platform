package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.CreateRoleRequest;
import com.abhisek.asep.identity.application.dto.response.RoleResponse;
import com.abhisek.asep.identity.application.service.RoleService;
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
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Tag(
        name = "Role Management",
        description = "Manage application roles"
)
public class RoleController {

    private final RoleService roleService;

    @PostMapping
    @Operation(
            summary = "Create Role",
            description = "Creates a new application role."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Role created"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Role already exists")
    })
    public ResponseEntity<ApiResponse<RoleResponse>> create(
            @Valid @RequestBody CreateRoleRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Role created successfully",
                                roleService.create(request)
                        )
                );
    }
    @Operation(
            summary = "List Roles",
            description = "Returns all roles."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResponse>>> findAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Roles retrieved successfully",
                        roleService.findAll()
                )
        );
    }
    @Operation(
            summary = "Find Role",
            description = "Returns role by id."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<RoleResponse>> findById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Role retrieved successfully",
                        roleService.findById(id)
                )
        );
    }
    @Operation(
            summary = "Delete Role",
            description = "Deletes a role."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        roleService.delete(id);

        return ResponseEntity.noContent().build();
    }
}