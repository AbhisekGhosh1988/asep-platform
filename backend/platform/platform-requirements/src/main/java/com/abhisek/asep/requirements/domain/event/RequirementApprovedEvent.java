package com.abhisek.asep.requirements.domain.event;



import com.abhisek.asep.common.model.DomainEvent;

import java.time.Instant;

public record RequirementApprovedEvent(

        String requirementId,

        String projectId,

        String approvedBy

        , Instant occurredOn

)implements DomainEvent {
}