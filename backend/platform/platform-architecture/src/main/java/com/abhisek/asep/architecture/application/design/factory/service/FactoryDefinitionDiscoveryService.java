package com.abhisek.asep.architecture.application.design.factory.service;

import com.abhisek.asep.architecture.application.design.factory.ai.dto.FactoryDefinitionDiscoveryResponse;

public interface FactoryDefinitionDiscoveryService {

    FactoryDefinitionDiscoveryResponse discover(
            String aggregateId);

}