package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.Permission;
import com.abhisek.asep.identity.infrastructure.persistence.entity.PermissionEntity;

public interface PermissionPersistenceMapper {

    Permission toDomain(PermissionEntity entity);

    PermissionEntity toEntity(Permission permission);

}