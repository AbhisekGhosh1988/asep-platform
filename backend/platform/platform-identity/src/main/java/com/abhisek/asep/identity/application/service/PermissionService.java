package com.abhisek.asep.identity.application.service;

import com.abhisek.asep.identity.application.dto.request.CreatePermissionRequest;
import com.abhisek.asep.identity.application.dto.response.PermissionResponse;

import java.util.List;

public interface PermissionService {

    PermissionResponse create(CreatePermissionRequest request);

    PermissionResponse findById(String id);

    List<PermissionResponse> findAll();

    void delete(String id);

}