package com.abhisek.asep.architecture.application.design.query.service;

import com.abhisek.asep.architecture.application.design.query.ai.dto.QueryDefinitionDiscoveryResponse;

public interface QueryDefinitionDiscoveryService {

    QueryDefinitionDiscoveryResponse discover(
            String aggregateId);

}