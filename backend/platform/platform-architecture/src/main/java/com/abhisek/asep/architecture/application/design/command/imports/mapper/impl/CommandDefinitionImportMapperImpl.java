package com.abhisek.asep.architecture.application.design.command.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.command.imports.dto.request.CommandDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.command.imports.mapper.CommandDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import org.springframework.stereotype.Component;

@Component
public class CommandDefinitionImportMapperImpl
        implements CommandDefinitionImportMapper {

    @Override
    public CommandDefinition toCommand(
            CommandDefinitionImportRequest request) {

        return CommandDefinition.builder()
                .aggregateId(request.getAggregateId())
                .name(request.getName())
                .description(request.getDescription())
                .build();

    }

}