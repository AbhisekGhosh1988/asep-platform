package com.abhisek.asep.architecture.domain.repository;

import com.abhisek.asep.architecture.domain.model.Relationship;

import java.util.List;
import java.util.Optional;

public interface RelationshipRepository {

    Relationship save(Relationship relationship);

    Optional<Relationship> findById(String id);

    List<Relationship> findBySourceEntityId(String entityId);

    boolean existsBySourceEntityIdAndTargetEntityIdAndFieldName(
            String sourceEntityId,
            String targetEntityId,
            String fieldName);

}