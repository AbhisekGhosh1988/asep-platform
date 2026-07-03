package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.CreatePermissionRequest;
import com.abhisek.asep.identity.application.dto.response.PermissionResponse;
import com.abhisek.asep.identity.application.service.PermissionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/permissions")
@RequiredArgsConstructor
public class PermissionController {

    private final PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ApiResponse<PermissionResponse>> create(
            @Valid @RequestBody CreatePermissionRequest request) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(
                        ApiResponse.success(
                                "Permission created successfully",
                                permissionService.create(request)
                        )
                );
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<PermissionResponse>>> findAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Permissions retrieved successfully",
                        permissionService.findAll()
                )
        );
    }
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<PermissionResponse>> findById(
            @PathVariable String id) {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Permission retrieved successfully",
                        permissionService.findById(id)
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        permissionService.delete(id);

        return ResponseEntity.noContent().build();
    }
}