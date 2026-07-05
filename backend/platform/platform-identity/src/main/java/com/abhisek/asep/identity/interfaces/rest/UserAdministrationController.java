package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.core.web.BaseController;
import com.abhisek.asep.identity.application.dto.request.AssignRoleRequest;
import com.abhisek.asep.identity.application.service.UserAdministrationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
@Tag(name = "User Administration", description = "Administrative user management APIs")
public class UserAdministrationController extends BaseController {

    private final UserAdministrationService service;

    @PostMapping("/{id}/roles")
    @Operation(summary = "Assign a role", description = "Assign role to user.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> assignRole(@PathVariable String id, @Valid @RequestBody AssignRoleRequest request) {

        service.assignRole(id, request.getRoleId());
        return ok("Role assigned", null);
    }

    @DeleteMapping("/{id}/roles/{roleId}")
    @Operation(summary = "Remove role", description = "Remove role of a user.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> removeRole(@PathVariable String id, @PathVariable String roleId) {

        service.removeRole(id, roleId);
        return deleted("Role removed successfully");
    }

    @PutMapping("/{id}/enable")
    @Operation(summary = "Enable user", description = "Enable a user account.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> enable(@PathVariable String id) {

        service.enableUser(id);
        return ok("User enabled", null);
    }

    @PutMapping("/{id}/disable")
    @Operation(summary = "Disable user", description = "Disable a user account.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> disable(@PathVariable String id) {

        service.disableUser(id);
        return ok("User disabled", null);
    }

    @PutMapping("/{id}/lock")
    @Operation(summary = "Lock user", description = "Lock a user account.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> lock(@PathVariable String id) {

        service.lockUser(id);
        return ok("User locked", null);
    }

    @PutMapping("/{id}/unlock")
    @Operation(summary = "Unlock user", description = "Unlock a user account.")
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> unlock(@PathVariable String id) {

        service.unlockUser(id);
        return ok("User unlocked", null);
    }
}