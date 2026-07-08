package com.abhisek.asep.architecture.application.design.policy.service;

import com.abhisek.asep.architecture.application.design.policy.ai.dto.PolicyDefinitionDiscoveryResponse;

public interface PolicyDefinitionDiscoveryService {

    PolicyDefinitionDiscoveryResponse discover(
            String aggregateId);

}