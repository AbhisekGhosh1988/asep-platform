package com.abhisek.asep.project.domain.event;

import com.abhisek.asep.common.event.DomainEvent;

import java.time.Instant;

public record ProjectCreatedEvent(

        String projectId,

        String projectName,

        Instant occurredOn

) implements DomainEvent {
}