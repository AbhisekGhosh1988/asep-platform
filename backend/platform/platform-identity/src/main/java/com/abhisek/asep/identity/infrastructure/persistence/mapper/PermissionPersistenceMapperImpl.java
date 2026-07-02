package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.Permission;
import com.abhisek.asep.identity.infrastructure.persistence.entity.PermissionEntity;
import org.springframework.stereotype.Component;

@Component
public class PermissionPersistenceMapperImpl implements PermissionPersistenceMapper {

    @Override
    public Permission toDomain(PermissionEntity entity) {

        if (entity == null) {
            return null;
        }

        Permission permission = new Permission();
        permission.setId(entity.getId());
        permission.setName(entity.getName());
        permission.setDescription(entity.getDescription());

        return permission;
    }

    @Override
    public PermissionEntity toEntity(Permission permission) {

        if (permission == null) {
            return null;
        }

        return PermissionEntity.builder()
                .id(permission.getId())
                .name(permission.getName())
                .description(permission.getDescription())
                .build();
    }
}