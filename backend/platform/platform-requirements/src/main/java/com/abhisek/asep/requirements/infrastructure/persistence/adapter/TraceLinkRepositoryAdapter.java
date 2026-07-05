package com.abhisek.asep.requirements.infrastructure.persistence.adapter;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.model.TraceLink;
import com.abhisek.asep.requirements.domain.repository.TraceLinkRepository;
import com.abhisek.asep.requirements.infrastructure.persistence.mapper.TraceLinkPersistenceMapper;
import com.abhisek.asep.requirements.infrastructure.persistence.repository.JpaTraceLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class TraceLinkRepositoryAdapter implements TraceLinkRepository {

    private final JpaTraceLinkRepository repository;

    private final TraceLinkPersistenceMapper mapper;

    @Override
    public TraceLink save(TraceLink traceLink) {

        return mapper.toDomain(repository.save(mapper.toEntity(traceLink)));
    }

    @Override
    public Optional<TraceLink> findById(String id) {

        return repository.findById(id).map(mapper::toDomain);
    }

    @Override
    public List<TraceLink> findBySource(TraceEntityType sourceType, String sourceId) {

        return repository.findBySourceTypeAndSourceId(sourceType, sourceId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<TraceLink> findByTarget(TraceEntityType targetType, String targetId) {

        return repository.findByTargetTypeAndTargetId(targetType, targetId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public List<TraceLink> findAllByEntity(TraceEntityType entityType, String entityId) {

        return repository.findBySourceTypeAndSourceIdOrTargetTypeAndTargetId(entityType, entityId, entityType, entityId).stream().map(mapper::toDomain).toList();
    }

    @Override
    public void delete(String id) {

        repository.deleteById(id);

    }

}