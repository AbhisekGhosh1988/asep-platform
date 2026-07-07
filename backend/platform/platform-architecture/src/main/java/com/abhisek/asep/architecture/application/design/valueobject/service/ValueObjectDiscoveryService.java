package com.abhisek.asep.architecture.application.design.valueobject.service;

import com.abhisek.asep.architecture.application.design.valueobject.ai.dto.ValueObjectDiscoveryResponse;

public interface ValueObjectDiscoveryService {

    ValueObjectDiscoveryResponse discover(String aggregateId);

}