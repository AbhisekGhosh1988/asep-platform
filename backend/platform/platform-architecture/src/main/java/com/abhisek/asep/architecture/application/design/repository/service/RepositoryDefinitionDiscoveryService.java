package com.abhisek.asep.architecture.application.design.repository.service;

import com.abhisek.asep.architecture.application.design.repository.ai.dto.RepositoryDefinitionDiscoveryResponse;

public interface RepositoryDefinitionDiscoveryService {

    RepositoryDefinitionDiscoveryResponse discover(
            String aggregateId);

}