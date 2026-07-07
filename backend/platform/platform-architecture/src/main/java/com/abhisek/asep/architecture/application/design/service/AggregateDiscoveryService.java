package com.abhisek.asep.architecture.application.design.service;

import com.abhisek.asep.architecture.application.design.ai.dto.AggregateDiscoveryResponse;

public interface AggregateDiscoveryService {

    AggregateDiscoveryResponse discover(String architectureId);

}