package com.abhisek.asep.architecture.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Specification {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * Specification name.
     *
     * Example:
     * ActiveCustomerSpecification
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Business rule expression.
     */
    private String expression;

    /**
     * Audit fields.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}