package com.abhisek.asep.architecture.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Entity {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * Entity name.
     */
    private String name;

    /**
     * Entity description.
     */
    private String description;

    /**
     * Indicates whether this is the Aggregate Root.
     */
    private Boolean rootEntity;

    /**
     * Audit fields.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}