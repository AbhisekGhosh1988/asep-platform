package com.abhisek.asep.requirements.application.service.impl;
import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.requirements.application.service.TraceLinkService;
import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.enums.TraceRelationType;
import com.abhisek.asep.requirements.domain.exception.TraceLinkNotFoundException;
import com.abhisek.asep.requirements.domain.model.TraceLink;
import com.abhisek.asep.requirements.domain.repository.TraceLinkRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class TraceLinkServiceImpl implements TraceLinkService {

    private final TraceLinkRepository repository;

    @Override
    public TraceLink createLink(TraceEntityType sourceType, String sourceId, TraceEntityType targetType, String targetId, TraceRelationType relationType, String createdBy) {

        if (sourceType == targetType && sourceId.equals(targetId)) {

            throw new IllegalArgumentException("Self reference is not allowed");

        }

        List<TraceLink> existing = repository.findBySource(sourceType, sourceId);

        boolean duplicate = existing.stream().anyMatch(link ->

                link.getTargetType() == targetType &&

                        link.getTargetId().equals(targetId) &&

                        link.getRelationType() == relationType);

        if (duplicate) {

            throw new IllegalStateException("Trace link already exists");

        }

        TraceLink traceLink = TraceLink.builder().id(UUID.randomUUID().toString()).sourceType(sourceType).sourceId(sourceId).targetType(targetType).targetId(targetId).relationType(relationType).createdBy(createdBy).createdAt(Instant.now()).build();

        return repository.save(traceLink);

    }

    @Override
    public void deleteLink(String traceLinkId) {

        RepositorySupport.require(

                repository.findById(traceLinkId),

                () -> new TraceLinkNotFoundException("Trace link not found"));

        repository.delete(traceLinkId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TraceLink> outgoingLinks(TraceEntityType entityType, String entityId) {

        return repository.findBySource(entityType, entityId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TraceLink> incomingLinks(TraceEntityType entityType, String entityId) {

        return repository.findByTarget(entityType, entityId);

    }

    @Override
    @Transactional(readOnly = true)
    public List<TraceLink> allLinks(TraceEntityType entityType, String entityId) {

        return repository.findAllByEntity(entityType, entityId);

    }

}