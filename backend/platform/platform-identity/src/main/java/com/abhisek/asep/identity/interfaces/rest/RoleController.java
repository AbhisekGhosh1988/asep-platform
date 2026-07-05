package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.identity.application.dto.request.CreateRoleRequest;
import com.abhisek.asep.identity.application.dto.response.RoleResponse;
import com.abhisek.asep.identity.application.service.RoleService;
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
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
@Tag(name = "Role Management", description = "Manage application roles")
public class RoleController extends BaseController {

    private final RoleService roleService;

    @PostMapping
    @Operation(summary = "Create Role", description = "Creates a new application role.")
    @SecurityRequirement(name = "Bearer Authentication")
    @ApiResponses({@io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "201", description = "Role created"), @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "409", description = "Role already exists")})
    public ResponseEntity<ApiResponse<RoleResponse>> create(@Valid @RequestBody CreateRoleRequest request) {

        return created("Role created successfully", roleService.create(request));
    }

    @GetMapping
    @Operation(summary = "List Roles", description = "Returns all roles.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<List<RoleResponse>>> findAll() {

        return ok("Roles retrieved successfully", roleService.findAll());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Find Role", description = "Returns role by id.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<RoleResponse>> findById(@PathVariable String id) {

        return ok("Role retrieved successfully", roleService.findById(id));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Delete Role", description = "Deletes a role.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable String id) {

        roleService.delete(id);
        return deleted("Role deleted successfully");
    }
}