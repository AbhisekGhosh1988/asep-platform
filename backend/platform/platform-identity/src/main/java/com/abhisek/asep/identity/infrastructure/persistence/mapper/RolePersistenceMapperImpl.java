package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.infrastructure.persistence.entity.RoleEntity;
import org.springframework.stereotype.Component;

@Component
public class RolePersistenceMapperImpl implements RolePersistenceMapper {

    @Override
    public Role toDomain(RoleEntity entity) {

        if (entity == null) {
            return null;
        }

        return Role.builder()
                .id(entity.getId())
                .roleType(entity.getRoleType())
                .build();
    }

    @Override
    public RoleEntity toEntity(Role role) {

        if (role == null) {
            return null;
        }

        return RoleEntity.builder()
                .id(role.getId())
                .roleType(role.getRoleType())
                .build();
    }
}