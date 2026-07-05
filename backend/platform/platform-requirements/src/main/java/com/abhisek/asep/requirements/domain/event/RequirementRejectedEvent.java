package com.abhisek.asep.requirements.domain.event;


import com.abhisek.asep.common.model.DomainEvent;

import java.time.Instant;

public record RequirementRejectedEvent(

        String requirementId,

        String projectId,

        String reason
        , Instant occurredOn

)implements DomainEvent {
}