package com.abhisek.asep.architecture.application.design.command.query.service;

import com.abhisek.asep.architecture.application.design.command.query.dto.CommandDefinitionDetailsResponse;

import java.util.List;

public interface CommandDefinitionQueryService {

    CommandDefinitionDetailsResponse getCommand(
            String commandId);

    List<CommandDefinitionDetailsResponse> getCommands(
            String aggregateId);

}