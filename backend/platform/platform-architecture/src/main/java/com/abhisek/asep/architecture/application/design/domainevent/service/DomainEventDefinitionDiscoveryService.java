package com.abhisek.asep.architecture.application.design.domainevent.service;

import com.abhisek.asep.architecture.application.design.domainevent.ai.dto.DomainEventDefinitionDiscoveryResponse;

public interface DomainEventDefinitionDiscoveryService {

    DomainEventDefinitionDiscoveryResponse discover(
            String aggregateId);

}