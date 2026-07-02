package com.abhisek.asep.identity.domain.repository;

import com.abhisek.asep.identity.domain.model.Permission;

import java.util.Optional;

public interface PermissionRepository {

    Permission save(Permission permission);

    Optional<Permission> findById(String id);

    Optional<Permission> findByName(String name);

    boolean existsByName(String name);

}