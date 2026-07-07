package com.abhisek.asep.architecture.application.design.relationship.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.application.design.relationship.query.mapper.RelationshipQueryMapper;
import com.abhisek.asep.architecture.domain.model.Relationship;
import org.springframework.stereotype.Component;

@Component
public class RelationshipQueryMapperImpl
        implements RelationshipQueryMapper {

    @Override
    public RelationshipDetailsResponse toResponse(
            Relationship relationship) {

        if (relationship == null) {
            return null;
        }

        return RelationshipDetailsResponse.builder()
                .id(relationship.getId())
                .sourceEntityId(relationship.getSourceEntityId())
                .targetEntityId(relationship.getTargetEntityId())
                .relationshipType(relationship.getRelationshipType())
                .fieldName(relationship.getFieldName())
                .mappedBy(relationship.getMappedBy())
                .cascadeType(relationship.getCascadeType())
                .fetchType(relationship.getFetchType())
                .optional(relationship.getOptional())
                .orphanRemoval(relationship.getOrphanRemoval())
                .description(relationship.getDescription())
                .build();

    }

}