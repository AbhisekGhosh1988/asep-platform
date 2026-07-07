package com.abhisek.asep.architecture.infrastructure.persistence.repository;

import com.abhisek.asep.architecture.infrastructure.persistence.entity.RelationshipEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaRelationshipRepository
        extends JpaRepository<RelationshipEntity, String> {

    List<RelationshipEntity> findBySourceEntityId(
            String sourceEntityId);

    boolean existsBySourceEntityIdAndTargetEntityIdAndFieldName(
            String sourceEntityId,
            String targetEntityId,
            String fieldName);

}