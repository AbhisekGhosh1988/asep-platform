package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
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
@Tag(
        name = "User Administration",
        description = "Administrative user management APIs"
)
public class UserAdministrationController {

    private final UserAdministrationService service;

    @PostMapping("/{id}/roles")
    @Operation(
            summary = "Assign a role",
            description = "Assign role to user."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> assignRole(
            @PathVariable String id,
            @Valid @RequestBody AssignRoleRequest request) {

        service.assignRole(id, request.getRoleId());

        return ResponseEntity.ok(
                ApiResponse.success("Role assigned", null)
        );
    }
    @PostMapping
    @Operation(
            summary = "Remove role",
            description = "Remove role of a user."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    @DeleteMapping("/{id}/roles/{roleId}")
    public ResponseEntity<Void> removeRole(
            @PathVariable String id,
            @PathVariable String roleId) {

        service.removeRole(id, roleId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/enable")
    @Operation(
            summary = "Enable role",
            description = "Enable role of a user."
    )
    @SecurityRequirement(name = "Bearer Authentication")
    public ResponseEntity<ApiResponse<Void>> enable(
            @PathVariable String id) {

        service.enableUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User enabled", null)
        );
    }
    @PutMapping("/{id}/disable")
    @Operation(
            summary = "Disable role",
            description = "Disable role of a user."
    )
    public ResponseEntity<ApiResponse<Void>> disable(
            @PathVariable String id) {

        service.disableUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User disabled", null)
        );
    }

    @PutMapping("/{id}/lock")
    @Operation(
            summary = "Lock role",
            description = "Lock role of a user."
    )
    public ResponseEntity<ApiResponse<Void>> lock(
            @PathVariable String id) {

        service.lockUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User locked", null)
        );
    }

    @PutMapping("/{id}/unlock")
    @Operation(
            summary = "UnLock role",
            description = "UnLock role of a user."
    )
    public ResponseEntity<ApiResponse<Void>> unlock(
            @PathVariable String id) {

        service.unlockUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User unlocked", null)
        );
    }
}