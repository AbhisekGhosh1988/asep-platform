package com.abhisek.asep.architecture.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Policy {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * Policy name.
     *
     * Example:
     * CustomerRegistrationPolicy
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Business policy definition.
     */
    private String rule;

    /**
     * Audit fields.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}