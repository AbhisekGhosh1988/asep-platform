package com.abhisek.asep.architecture.application.design.relationship.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.relationship.imports.dto.request.RelationshipImportRequest;
import com.abhisek.asep.architecture.application.design.relationship.imports.mapper.RelationshipImportMapper;
import com.abhisek.asep.architecture.domain.model.Relationship;
import org.springframework.stereotype.Component;

@Component
public class RelationshipImportMapperImpl
        implements RelationshipImportMapper {

    @Override
    public Relationship toRelationship(
            RelationshipImportRequest request) {

        return Relationship.builder()
                .sourceEntityId(request.getSourceEntityId())
                .targetEntityId(request.getTargetEntityId())
                .relationshipType(request.getRelationshipType())
                .fieldName(request.getFieldName())
                .mappedBy(request.getMappedBy())
                .cascadeType(request.getCascadeType())
                .fetchType(request.getFetchType())
                .optional(request.getOptional())
                .orphanRemoval(request.getOrphanRemoval())
                .description(request.getDescription())
                .build();

    }

}