package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.AssignRoleRequest;
import com.abhisek.asep.identity.application.service.UserAdministrationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/admin/users")
@RequiredArgsConstructor
public class UserAdministrationController {

    private final UserAdministrationService service;

    @PostMapping("/{id}/roles")
    public ResponseEntity<ApiResponse<Void>> assignRole(
            @PathVariable String id,
            @Valid @RequestBody AssignRoleRequest request) {

        service.assignRole(id, request.getRoleId());

        return ResponseEntity.ok(
                ApiResponse.success("Role assigned", null)
        );
    }
    @DeleteMapping("/{id}/roles/{roleId}")
    public ResponseEntity<Void> removeRole(
            @PathVariable String id,
            @PathVariable String roleId) {

        service.removeRole(id, roleId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}/enable")
    public ResponseEntity<ApiResponse<Void>> enable(
            @PathVariable String id) {

        service.enableUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User enabled", null)
        );
    }
    @PutMapping("/{id}/disable")
    public ResponseEntity<ApiResponse<Void>> disable(
            @PathVariable String id) {

        service.disableUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User disabled", null)
        );
    }

    @PutMapping("/{id}/lock")
    public ResponseEntity<ApiResponse<Void>> lock(
            @PathVariable String id) {

        service.lockUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User locked", null)
        );
    }

    @PutMapping("/{id}/unlock")
    public ResponseEntity<ApiResponse<Void>> unlock(
            @PathVariable String id) {

        service.unlockUser(id);

        return ResponseEntity.ok(
                ApiResponse.success("User unlocked", null)
        );
    }
}