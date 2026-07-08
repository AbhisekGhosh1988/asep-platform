package com.abhisek.asep.architecture.application.design.command.imports.service;

import com.abhisek.asep.architecture.application.design.command.imports.dto.request.CommandDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.command.imports.dto.response.CommandDefinitionImportResponse;

public interface CommandDefinitionImportService {

    CommandDefinitionImportResponse importCommand(
            CommandDefinitionImportRequest request);

}