package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.infrastructure.mapper.BoundedContextPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.BoundedContextEntity;
import org.springframework.stereotype.Component;

@Component
public class BoundedContextPersistenceMapperImpl
        implements BoundedContextPersistenceMapper {

    @Override
    public BoundedContextEntity toEntity(BoundedContext boundedContext) {

        if (boundedContext == null) {
            return null;
        }

        return BoundedContextEntity.builder()
                .id(boundedContext.getId())
                .architectureId(boundedContext.getArchitectureId())
                .name(boundedContext.getName())
                .description(boundedContext.getDescription())
                .responsibility(boundedContext.getResponsibility())
                .createdBy(boundedContext.getCreatedBy())
                .createdAt(boundedContext.getCreatedAt())
                .updatedBy(boundedContext.getUpdatedBy())
                .updatedAt(boundedContext.getUpdatedAt())
                .build();

    }

    @Override
    public BoundedContext toDomain(BoundedContextEntity entity) {

        if (entity == null) {
            return null;
        }

        return BoundedContext.builder()
                .id(entity.getId())
                .architectureId(entity.getArchitectureId())
                .name(entity.getName())
                .description(entity.getDescription())
                .responsibility(entity.getResponsibility())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}