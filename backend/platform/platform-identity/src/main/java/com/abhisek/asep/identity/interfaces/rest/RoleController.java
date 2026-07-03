package com.abhisek.asep.identity.interfaces.rest;

import com.abhisek.asep.common.response.ApiResponse;
import com.abhisek.asep.identity.application.dto.request.CreateRoleRequest;
import com.abhisek.asep.identity.application.dto.response.RoleResponse;
import com.abhisek.asep.identity.application.service.RoleService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;

    @PostMapping
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
    @GetMapping
    public ResponseEntity<ApiResponse<List<RoleResponse>>> findAll() {

        return ResponseEntity.ok(
                ApiResponse.success(
                        "Roles retrieved successfully",
                        roleService.findAll()
                )
        );
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(
            @PathVariable String id) {

        roleService.delete(id);

        return ResponseEntity.noContent().build();
    }
}