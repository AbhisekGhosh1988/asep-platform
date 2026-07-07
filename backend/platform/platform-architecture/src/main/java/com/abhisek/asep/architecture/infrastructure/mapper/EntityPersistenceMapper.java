package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Entity;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.EntityEntity;

public interface EntityPersistenceMapper {

    EntityEntity toEntity(Entity entity);

    Entity toDomain(EntityEntity entity);

}