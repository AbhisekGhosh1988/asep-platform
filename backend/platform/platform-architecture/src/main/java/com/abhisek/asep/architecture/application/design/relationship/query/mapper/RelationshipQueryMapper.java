package com.abhisek.asep.architecture.application.design.relationship.query.mapper;

import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.domain.model.Relationship;

public interface RelationshipQueryMapper {

    RelationshipDetailsResponse toResponse(Relationship relationship);

}