package com.abhisek.asep.architecture.application.design.relationship.service;

import com.abhisek.asep.architecture.application.design.relationship.ai.dto.RelationshipDiscoveryResponse;

public interface RelationshipDiscoveryService {

    RelationshipDiscoveryResponse discover(
            String aggregateId);

}