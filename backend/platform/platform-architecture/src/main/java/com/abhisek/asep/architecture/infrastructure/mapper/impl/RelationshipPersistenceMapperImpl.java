package com.abhisek.asep.architecture.infrastructure.mapper.impl;

import com.abhisek.asep.architecture.domain.model.Relationship;
import com.abhisek.asep.architecture.infrastructure.mapper.RelationshipPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.RelationshipEntity;
import org.springframework.stereotype.Component;

@Component
public class RelationshipPersistenceMapperImpl
        implements RelationshipPersistenceMapper {

    @Override
    public RelationshipEntity toEntity(
            Relationship relationship) {

        if (relationship == null) {
            return null;
        }

        return RelationshipEntity.builder()
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
                .createdBy(relationship.getCreatedBy())
                .createdAt(relationship.getCreatedAt())
                .updatedBy(relationship.getUpdatedBy())
                .updatedAt(relationship.getUpdatedAt())
                .build();

    }

    @Override
    public Relationship toDomain(
            RelationshipEntity entity) {

        if (entity == null) {
            return null;
        }

        return Relationship.builder()
                .id(entity.getId())
                .sourceEntityId(entity.getSourceEntityId())
                .targetEntityId(entity.getTargetEntityId())
                .relationshipType(entity.getRelationshipType())
                .fieldName(entity.getFieldName())
                .mappedBy(entity.getMappedBy())
                .cascadeType(entity.getCascadeType())
                .fetchType(entity.getFetchType())
                .optional(entity.getOptional())
                .orphanRemoval(entity.getOrphanRemoval())
                .description(entity.getDescription())
                .createdBy(entity.getCreatedBy())
                .createdAt(entity.getCreatedAt())
                .updatedBy(entity.getUpdatedBy())
                .updatedAt(entity.getUpdatedAt())
                .build();

    }

}