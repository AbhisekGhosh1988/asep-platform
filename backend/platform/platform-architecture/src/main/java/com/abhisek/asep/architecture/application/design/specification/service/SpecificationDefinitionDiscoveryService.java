package com.abhisek.asep.architecture.application.design.specification.service;

import com.abhisek.asep.architecture.application.design.specification.ai.dto.SpecificationDefinitionDiscoveryResponse;

public interface SpecificationDefinitionDiscoveryService {

    SpecificationDefinitionDiscoveryResponse discover(
            String aggregateId);

}