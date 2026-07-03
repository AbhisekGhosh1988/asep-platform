package com.abhisek.asep.identity.application.service.impl;

import com.abhisek.asep.identity.application.dto.request.CreateRoleRequest;
import com.abhisek.asep.identity.application.dto.response.RoleResponse;
import com.abhisek.asep.identity.application.service.RoleService;
import com.abhisek.asep.identity.domain.exception.RoleNotFoundException;
import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.domain.repository.RoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {

    private final RoleRepository roleRepository;

    @Override
    public RoleResponse create(CreateRoleRequest request) {

        Role role = Role.builder()
                .roleType(request.getRoleType())
                .build();

        role = roleRepository.save(role);

        return RoleResponse.builder()
                .id(role.getId())
                .roleType(role.getRoleType())
                .build();
    }

    @Override
    public List<RoleResponse> findAll() {

        return roleRepository.findAll()
                .stream()
                .map(role -> RoleResponse.builder()
                        .id(role.getId())
                        .roleType(role.getRoleType())
                        .build())
                .toList();
    }

    @Override
    public RoleResponse findById(String id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new RoleNotFoundException(
                                "Role not found: " + id));

        return RoleResponse.builder()
                .id(role.getId())
                .roleType(role.getRoleType())
                .build();
    }

    @Override
    public void delete(String id) {

        Role role = roleRepository.findById(id)
                .orElseThrow(() ->
                        new RoleNotFoundException(
                                "Role not found: " + id));

        roleRepository.delete(role);
    }
}