package com.abhisek.asep.architecture.application.design.attribute.service;

import com.abhisek.asep.architecture.application.design.attribute.ai.dto.AttributeDiscoveryResponse;

public interface AttributeDiscoveryService {

    AttributeDiscoveryResponse discover(
            String entityId);

}