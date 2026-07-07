package com.abhisek.asep.architecture.application.design.relationship.imports.mapper;

import com.abhisek.asep.architecture.application.design.relationship.imports.dto.request.RelationshipImportRequest;
import com.abhisek.asep.architecture.domain.model.Relationship;

public interface RelationshipImportMapper {

    Relationship toRelationship(
            RelationshipImportRequest request);

}