package com.abhisek.asep.requirements.infrastructure.persistence.repository;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.infrastructure.persistence.entity.TraceLinkEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JpaTraceLinkRepository extends JpaRepository<TraceLinkEntity, String> {

    List<TraceLinkEntity> findBySourceTypeAndSourceId(TraceEntityType sourceType, String sourceId);

    List<TraceLinkEntity> findByTargetTypeAndTargetId(TraceEntityType targetType, String targetId);

    List<TraceLinkEntity> findBySourceTypeAndSourceIdOrTargetTypeAndTargetId(TraceEntityType sourceType, String sourceId, TraceEntityType targetType, String targetId);

}