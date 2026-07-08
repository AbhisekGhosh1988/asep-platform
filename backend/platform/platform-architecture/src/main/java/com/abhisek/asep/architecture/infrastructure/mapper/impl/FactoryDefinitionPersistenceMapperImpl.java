package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.FactoryDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.FactoryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.FactoryDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class FactoryDefinitionPersistenceMapperImpl
        implements FactoryDefinitionPersistenceMapper {

    @Override
    public FactoryDefinitionEntity toEntity(
            FactoryDefinition factoryDefinition) {

        if (factoryDefinition == null) {
            return null;
        }

        return FactoryDefinitionEntity.builder()
                .id(factoryDefinition.getId())
                .aggregateId(factoryDefinition.getAggregateId())
                .name(factoryDefinition.getName())
                .description(factoryDefinition.getDescription())
                .createdBy(factoryDefinition.getCreatedBy())
                .createdAt(factoryDefinition.getCreatedAt())
                .updatedBy(factoryDefinition.getUpdatedBy())
                .updatedAt(factoryDefinition.getUpdatedAt())
                .build();

    }

    @Override
    public FactoryDefinition toDomain(
            FactoryDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return FactoryDefinition.builder()
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