package com.abhisek.asep.requirements.domain.event;

import com.abhisek.asep.common.model.DomainEvent;

import java.time.Instant;

public record RequirementUpdatedEvent(

        String requirementId,

        String projectId

        , Instant occurredOn

)implements DomainEvent {
}