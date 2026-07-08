package com.abhisek.asep.architecture.application.design.command.query.service;

import com.abhisek.asep.architecture.application.design.command.query.dto.CommandDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.command.query.mapper.CommandDefinitionQueryMapper;
import com.abhisek.asep.architecture.domain.repository.CommandDefinitionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommandDefinitionQueryServiceImpl implements CommandDefinitionQueryService {

    private final CommandDefinitionRepository repository;

    private final CommandDefinitionQueryMapper mapper;

    @Override
    public CommandDefinitionDetailsResponse getCommand(String commandId) {

        return repository.findById(commandId).map(mapper::toResponse).orElseThrow(() -> new IllegalArgumentException("Command not found : " + commandId));

    }

    @Override
    public List<CommandDefinitionDetailsResponse> getCommands(String aggregateId) {

        return repository.findByAggregateId(aggregateId).stream().map(mapper::toResponse).toList();

    }

}