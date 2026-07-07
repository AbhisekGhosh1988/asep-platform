package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.RepositoryDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.RepositoryDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class RepositoryDefinitionPersistenceMapperImpl implements RepositoryDefinitionPersistenceMapper {

    @Override
    public RepositoryDefinitionEntity toEntity(RepositoryDefinition repository) {

        if (repository == null) {
            return null;
        }

        return RepositoryDefinitionEntity.builder().id(repository.getId()).aggregateId(repository.getAggregateId()).name(repository.getName()).description(repository.getDescription()).createdBy(repository.getCreatedBy()).createdAt(repository.getCreatedAt()).updatedBy(repository.getUpdatedBy()).updatedAt(repository.getUpdatedAt()).build();

    }

    @Override
    public RepositoryDefinition toDomain(RepositoryDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return RepositoryDefinition.builder().id(entity.getId()).aggregateId(entity.getAggregateId()).name(entity.getName()).description(entity.getDescription()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).updatedBy(entity.getUpdatedBy()).updatedAt(entity.getUpdatedAt()).build();

    }

}