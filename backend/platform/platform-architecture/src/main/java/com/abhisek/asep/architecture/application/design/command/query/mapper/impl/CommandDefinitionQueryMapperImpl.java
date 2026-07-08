package com.abhisek.asep.architecture.application.design.command.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.command.query.dto.CommandDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.command.query.mapper.CommandDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import org.springframework.stereotype.Component;

@Component
public class CommandDefinitionQueryMapperImpl
        implements CommandDefinitionQueryMapper {

    @Override
    public CommandDefinitionDetailsResponse toResponse(
            CommandDefinition command) {

        if (command == null) {
            return null;
        }

        return CommandDefinitionDetailsResponse.builder()
                .id(command.getId())
                .aggregateId(command.getAggregateId())
                .name(command.getName())
                .description(command.getDescription())
                .build();

    }

}