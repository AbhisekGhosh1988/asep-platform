package com.abhisek.asep.architecture.application.design.command.query.mapper;

import com.abhisek.asep.architecture.application.design.command.query.dto.CommandDefinitionDetailsResponse;
import com.abhisek.asep.architecture.domain.model.CommandDefinition;

public interface CommandDefinitionQueryMapper {

    CommandDefinitionDetailsResponse toResponse(
            CommandDefinition command);

}