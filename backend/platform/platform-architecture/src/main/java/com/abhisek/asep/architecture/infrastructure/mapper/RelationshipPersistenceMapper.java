package com.abhisek.asep.architecture.infrastructure.mapper;

import com.abhisek.asep.architecture.domain.model.Relationship;
import com.abhisek.asep.architecture.infrastructure.persistence.entity.RelationshipEntity;

public interface RelationshipPersistenceMapper {
    RelationshipEntity toEntity(Relationship relationship);

    Relationship toDomain(RelationshipEntity entity);
}
