package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Entity;
import com.abhisek.asep.architecture.infrastructure.mapper.EntityPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.EntityEntity;
import org.springframework.stereotype.Component;

@Component
public class EntityPersistenceMapperImpl
        implements EntityPersistenceMapper {

    @Override
    public EntityEntity toEntity(Entity entity) {

        if (entity == null) {
            return null;
        }

        return EntityEntity.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .rootEntity(entity.getRootEntity())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

    @Override
    public Entity toDomain(EntityEntity entity) {

        if (entity == null) {
            return null;
        }

        return Entity.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .rootEntity(entity.getRootEntity())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}