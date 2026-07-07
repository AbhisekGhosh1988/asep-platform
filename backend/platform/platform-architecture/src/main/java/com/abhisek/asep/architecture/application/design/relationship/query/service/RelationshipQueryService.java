package com.abhisek.asep.architecture.application.design.relationship.query.service;

import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;

import java.util.List;

public interface RelationshipQueryService {

    RelationshipDetailsResponse getRelationship(String relationshipId);

    List<RelationshipDetailsResponse> getRelationships(String sourceEntityId);

}