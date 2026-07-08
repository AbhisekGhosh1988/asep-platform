package com.abhisek.asep.architecture.application.design.command.service;

import com.abhisek.asep.architecture.application.design.command.ai.dto.CommandDefinitionDiscoveryResponse;

public interface CommandDefinitionDiscoveryService {

    CommandDefinitionDiscoveryResponse discover(
            String aggregateId);

}