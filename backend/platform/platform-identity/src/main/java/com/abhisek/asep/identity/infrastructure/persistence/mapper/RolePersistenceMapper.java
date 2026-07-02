package com.abhisek.asep.identity.infrastructure.persistence.mapper;

import com.abhisek.asep.identity.domain.model.Role;
import com.abhisek.asep.identity.infrastructure.persistence.entity.RoleEntity;

public interface RolePersistenceMapper {

    Role toDomain(RoleEntity entity);

    RoleEntity toEntity(Role role);

}