package com.abhisek.asep.architecture.application.design.command.imports.service;

import com.abhisek.asep.architecture.application.design.command.imports.dto.request.CommandDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.command.imports.dto.response.CommandDefinitionImportResponse;
import com.abhisek.asep.architecture.application.design.command.imports.mapper.CommandDefinitionImportMapper;
import com.abhisek.asep.architecture.domain.model.CommandDefinition;
import com.abhisek.asep.architecture.domain.repository.CommandDefinitionRepository;
import com.abhisek.asep.core.application.usecase.AbstractCreateUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CommandDefinitionImportServiceImpl extends AbstractCreateUseCase implements CommandDefinitionImportService {

    private final CommandDefinitionRepository repository;

    private final CommandDefinitionImportMapper mapper;

    @Override
    public CommandDefinitionImportResponse importCommand(CommandDefinitionImportRequest request) {

        if (repository.existsByAggregateIdAndName(request.getAggregateId(), request.getName())) {

            throw new IllegalArgumentException("Command already exists.");

        }

        CommandDefinition command = mapper.toCommand(request);

        command.setId(newId());

        command.setCreatedAt(now());
        command.setUpdatedAt(now());

        command.setCreatedBy(currentUser());
        command.setUpdatedBy(currentUser());

        command = repository.save(command);

        return CommandDefinitionImportResponse.builder().commandId(command.getId()).build();

    }

}