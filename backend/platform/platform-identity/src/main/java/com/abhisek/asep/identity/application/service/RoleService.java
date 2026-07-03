package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.identity.application.dto.request.CreateRoleRequest;
import com.abhisek.asep.identity.application.dto.response.RoleResponse;

import java.util.List;

public interface RoleService {

    RoleResponse create(CreateRoleRequest request);

    List<RoleResponse> findAll();

    RoleResponse findById(String id);

    void delete(String id);

}