package com.abhisek.asep.architecture.application.design.domainservice.service;

import com.abhisek.asep.architecture.application.design.domainservice.ai.dto.DomainServiceDefinitionDiscoveryResponse;

public interface DomainServiceDefinitionDiscoveryService {

    DomainServiceDefinitionDiscoveryResponse discover(
            String aggregateId);

}