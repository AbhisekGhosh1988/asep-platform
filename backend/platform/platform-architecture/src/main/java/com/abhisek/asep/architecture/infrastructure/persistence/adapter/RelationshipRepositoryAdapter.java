package com.abhisek.asep.architecture.infrastructure.persistence.adapter;

import com.abhisek.asep.architecture.domain.model.Relationship;
import com.abhisek.asep.architecture.domain.repository.RelationshipRepository;
import com.abhisek.asep.architecture.infrastructure.mapper.RelationshipPersistenceMapper;
import com.abhisek.asep.architecture.infrastructure.persistence.repository.JpaRelationshipRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class RelationshipRepositoryAdapter implements RelationshipRepository {

    private final JpaRelationshipRepository repository;

    private final RelationshipPersistenceMapper mapper;

    @Override
    public Relationship save(Relationship relationship) {

        return mapper.toDomain(repository.save(mapper.toEntity(relationship)));

    }

    @Override
    public Optional<Relationship> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);

    }

    @Override
    public List<Relationship> findBySourceEntityId(String entityId) {

        return repository.findBySourceEntityId(entityId).stream().map(mapper::toDomain).toList();

    }
    @Override
    public boolean existsBySourceEntityIdAndTargetEntityIdAndFieldName(
            String sourceEntityId,
            String targetEntityId,
            String fieldName) {

        return repository.existsBySourceEntityIdAndTargetEntityIdAndFieldName(
                sourceEntityId,
                targetEntityId,
                fieldName);

    }
}