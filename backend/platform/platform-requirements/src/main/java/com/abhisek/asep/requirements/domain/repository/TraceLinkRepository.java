package com.abhisek.asep.requirements.domain.repository;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.model.TraceLink;

import java.util.List;
import java.util.Optional;

public interface TraceLinkRepository {

    TraceLink save(TraceLink traceLink);

    Optional<TraceLink> findById(String id);

    List<TraceLink> findBySource(TraceEntityType sourceType, String sourceId);

    List<TraceLink> findByTarget(TraceEntityType targetType, String targetId);

    List<TraceLink> findAllByEntity(TraceEntityType entityType, String entityId);

    void delete(String id);

}