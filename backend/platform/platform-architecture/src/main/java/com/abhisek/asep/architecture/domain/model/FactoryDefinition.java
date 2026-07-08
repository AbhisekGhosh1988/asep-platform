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
public class FactoryDefinition {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Aggregate Id.
     */
    private String aggregateId;

    /**
     * Factory name.
     *
     * Examples
     *
     * CustomerFactory
     * OrderFactory
     * InvoiceFactory
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Audit.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}