package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.CommandDefinitionEntity;

public interface CommandDefinitionPersistenceMapper {

    CommandDefinitionEntity toEntity(
            CommandDefinition command);

    CommandDefinition toDomain(
            CommandDefinitionEntity entity);

}