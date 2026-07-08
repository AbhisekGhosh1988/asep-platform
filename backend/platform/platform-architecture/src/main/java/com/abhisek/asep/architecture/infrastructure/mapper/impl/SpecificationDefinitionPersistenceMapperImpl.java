package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.SpecificationDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.SpecificationDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.SpecificationDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class SpecificationDefinitionPersistenceMapperImpl
        implements SpecificationDefinitionPersistenceMapper {

    @Override
    public SpecificationDefinitionEntity toEntity(
            SpecificationDefinition specification) {

        if (specification == null) {
            return null;
        }

        return SpecificationDefinitionEntity.builder()
                .id(specification.getId())
                .aggregateId(specification.getAggregateId())
                .name(specification.getName())
                .description(specification.getDescription())
                .createdBy(specification.getCreatedBy())
                .createdAt(specification.getCreatedAt())
                .updatedBy(specification.getUpdatedBy())
                .updatedAt(specification.getUpdatedAt())
                .build();

    }

    @Override
    public SpecificationDefinition toDomain(
            SpecificationDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return SpecificationDefinition.builder()
                .id(entity.getId())
                .aggregateId(entity.getAggregateId())
                .name(entity.getName())
                .description(entity.getDescription())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}