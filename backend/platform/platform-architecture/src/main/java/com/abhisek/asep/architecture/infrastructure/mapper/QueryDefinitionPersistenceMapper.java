package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.QueryDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.QueryDefinitionEntity;

public interface QueryDefinitionPersistenceMapper {

    QueryDefinitionEntity toEntity(
            QueryDefinition queryDefinition);

    QueryDefinition toDomain(
            QueryDefinitionEntity entity);

}