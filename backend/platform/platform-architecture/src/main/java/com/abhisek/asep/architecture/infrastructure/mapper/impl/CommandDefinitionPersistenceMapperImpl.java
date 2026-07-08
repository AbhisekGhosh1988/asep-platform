package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import com.abhisek.asep.architecture.infrastructure.mapper.CommandDefinitionPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.CommandDefinitionEntity;
import org.springframework.stereotype.Component;

@Component
public class CommandDefinitionPersistenceMapperImpl implements CommandDefinitionPersistenceMapper {

    @Override
    public CommandDefinitionEntity toEntity(CommandDefinition command) {

        if (command == null) {
            return null;
        }

        return CommandDefinitionEntity.builder().id(command.getId()).aggregateId(command.getAggregateId()).name(command.getName()).description(command.getDescription()).createdBy(command.getCreatedBy()).createdAt(command.getCreatedAt()).updatedBy(command.getUpdatedBy()).updatedAt(command.getUpdatedAt()).build();

    }

    @Override
    public CommandDefinition toDomain(CommandDefinitionEntity entity) {

        if (entity == null) {
            return null;
        }

        return CommandDefinition.builder().id(entity.getId()).aggregateId(entity.getAggregateId()).name(entity.getName()).description(entity.getDescription()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).updatedBy(entity.getUpdatedBy()).updatedAt(entity.getUpdatedAt()).build();

    }

}