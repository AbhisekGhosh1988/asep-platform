package com.abhisek.asep.architecture.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DomainServiceDefinition {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * Service name.
     *
     * Example:
     * CustomerRegistrationService
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Audit fields.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}