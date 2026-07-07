package com.abhisek.asep.architecture.application.design.relationship.imports.service;

import com.abhisek.asep.architecture.application.design.relationship.imports.dto.request.RelationshipImportRequest;
import com.abhisek.asep.architecture.application.design.relationship.imports.dto.response.RelationshipImportResponse;

public interface RelationshipImportService {

    RelationshipImportResponse importRelationship(
            RelationshipImportRequest request);

}