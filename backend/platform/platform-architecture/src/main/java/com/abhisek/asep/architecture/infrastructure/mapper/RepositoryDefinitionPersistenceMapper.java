package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.RepositoryDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.RepositoryDefinitionEntity;

public interface RepositoryDefinitionPersistenceMapper {

    RepositoryDefinitionEntity toEntity(
            RepositoryDefinition repository);

    RepositoryDefinition toDomain(
            RepositoryDefinitionEntity entity);

}