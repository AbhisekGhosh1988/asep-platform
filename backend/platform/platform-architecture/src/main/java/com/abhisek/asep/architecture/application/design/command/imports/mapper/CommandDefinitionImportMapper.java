package com.abhisek.asep.architecture.application.design.command.imports.mapper;

import com.abhisek.asep.architecture.application.design.command.imports.dto.request.CommandDefinitionImportRequest;
import com.abhisek.asep.architecture.domain.model.CommandDefinition;

public interface CommandDefinitionImportMapper {

    CommandDefinition toCommand(
            CommandDefinitionImportRequest request);

}