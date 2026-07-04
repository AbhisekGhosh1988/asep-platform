package com.abhisek.asep.project.domain.event;

import com.abhisek.asep.common.event.DomainEvent;

import java.time.Instant;

public record ProjectActivatedEvent(
        String projectId,
        Instant occurredOn
) implements DomainEvent {
}