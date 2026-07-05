package com.abhisek.asep.project.domain.event;

import com.abhisek.asep.common.model.DomainEvent;

import java.time.Instant;

public record ProjectMemberAddedEvent(
        String projectId,
        String userId,
        Instant occurredOn
) implements DomainEvent {
}