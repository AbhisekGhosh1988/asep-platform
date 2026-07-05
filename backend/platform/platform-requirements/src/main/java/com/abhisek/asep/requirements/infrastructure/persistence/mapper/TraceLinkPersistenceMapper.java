package com.abhisek.asep.requirements.infrastructure.persistence.mapper;

import com.abhisek.asep.requirements.domain.model.TraceLink;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.TraceLinkEntity;
import org.springframework.stereotype.Component;

@Component
public class TraceLinkPersistenceMapper {

    public TraceLinkEntity toEntity(TraceLink domain) {

        if (domain == null) {
            return null;
        }

        return TraceLinkEntity.builder().id(domain.getId()).sourceType(domain.getSourceType()).sourceId(domain.getSourceId()).targetType(domain.getTargetType()).targetId(domain.getTargetId()).relationType(domain.getRelationType()).createdBy(domain.getCreatedBy()).createdAt(domain.getCreatedAt()).build();
    }

    public TraceLink toDomain(TraceLinkEntity entity) {

        if (entity == null) {
            return null;
        }

        return TraceLink.builder().id(entity.getId()).sourceType(entity.getSourceType()).sourceId(entity.getSourceId()).targetType(entity.getTargetType()).targetId(entity.getTargetId()).relationType(entity.getRelationType()).createdBy(entity.getCreatedBy()).createdAt(entity.getCreatedAt()).build();
    }

}