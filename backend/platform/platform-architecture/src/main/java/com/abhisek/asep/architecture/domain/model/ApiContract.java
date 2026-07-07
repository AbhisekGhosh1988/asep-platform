package com.abhisek.asep.architecture.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ApiContract {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * API name.
     */
    private String name;

    /**
     * Base REST path.
     *
     * Example:
     * /customers
     */
    private String basePath;

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