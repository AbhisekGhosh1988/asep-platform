package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.domain.enums.TraceEntityType;
import com.abhisek.asep.requirements.domain.enums.TraceRelationType;
import com.abhisek.asep.requirements.domain.model.TraceLink;

import java.util.List;

public interface TraceLinkService {

    TraceLink createLink(TraceEntityType sourceType, String sourceId, TraceEntityType targetType, String targetId, TraceRelationType relationType, String createdBy);

    void deleteLink(String traceLinkId);

    List<TraceLink> outgoingLinks(TraceEntityType entityType, String entityId);

    List<TraceLink> incomingLinks(TraceEntityType entityType, String entityId);

    List<TraceLink> allLinks(TraceEntityType entityType, String entityId);

}