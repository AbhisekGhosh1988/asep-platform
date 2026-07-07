package com.abhisek.asep.architecture.application.design.entity.service;

import com.abhisek.asep.architecture.application.design.entity.ai.dto.EntityDiscoveryResponse;

public interface EntityDiscoveryService {

    EntityDiscoveryResponse discover(String aggregateId);

}