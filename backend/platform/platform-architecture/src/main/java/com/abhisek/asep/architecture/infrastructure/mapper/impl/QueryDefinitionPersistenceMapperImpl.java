package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.QueryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.QueryDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class QueryDefinitionPersistenceMapperImpl
        implements QueryDefinitionPersistenceMapper {

    @Override
    public QueryDefinitionEntity toEntity(
            QueryDefinition queryDefinition) {

        if (queryDefinition == null) {
            return null;
        }

        return QueryDefinitionEntity.builder()
                .id(queryDefinition.getId())
                .aggregateId(queryDefinition.getAggregateId())
                .name(queryDefinition.getName())
                .description(queryDefinition.getDescription())
                .createdBy(queryDefinition.getCreatedBy())
                .createdAt(queryDefinition.getCreatedAt())
                .updatedBy(queryDefinition.getUpdatedBy())
                .updatedAt(queryDefinition.getUpdatedAt())
                .build();

    }

    @Override
    public QueryDefinition toDomain(
            QueryDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return QueryDefinition.builder()
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