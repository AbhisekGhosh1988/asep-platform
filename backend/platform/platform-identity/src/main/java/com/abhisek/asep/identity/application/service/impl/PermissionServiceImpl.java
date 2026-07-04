package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.dto.request.CreatePermissionRequest;
import com.abhisek.asep.identity.application.dto.response.PermissionResponse;
import com.abhisek.asep.identity.application.service.PermissionService;
import com.abhisek.asep.identity.domain.exception.PermissionNotFoundException;
import com.abhisek.asep.identity.domain.model.Permission;
import com.abhisek.asep.identity.domain.repository.PermissionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private final PermissionRepository permissionRepository;

    @Override
    public PermissionResponse create(CreatePermissionRequest request) {

        Permission permission = Permission.builder().name(request.getName()).description(request.getDescription()).build();

        permission = permissionRepository.save(permission);

        return map(permission);
    }

    @Override
    public PermissionResponse findById(String id) {

        return map(permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException("Permission not found: " + id)));
    }

    @Override
    public List<PermissionResponse> findAll() {

        return permissionRepository.findAll().stream().map(this::map).toList();
    }

    @Override
    public void delete(String id) {

        Permission permission = permissionRepository.findById(id).orElseThrow(() -> new PermissionNotFoundException("Permission not found: " + id));

        permissionRepository.delete(permission);
    }

    private PermissionResponse map(Permission permission) {

        return PermissionResponse.builder().id(permission.getId()).name(permission.getName()).description(permission.getDescription()).build();
    }
}