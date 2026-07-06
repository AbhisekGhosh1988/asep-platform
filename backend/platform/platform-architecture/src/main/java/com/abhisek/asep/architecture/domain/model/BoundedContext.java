package com.abhisek.asep.architecture.domain.model;

import com.abhisek.asep.architecture.domain.enums.ContextRelationshipType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoundedContext {

    /**
     * Unique Identifier
     */
    private String id;

    /**
     * Parent Architecture
     */
    private String architectureId;

    /**
     * Context Name
     */
    private String name;

    /**
     * Description
     */
    private String description;

    /**
     * Business Responsibility
     */
    private String responsibility;

    /**
     * Business Owner
     */
    private String owner;

    /**
     * Relationship with other contexts
     */
    private ContextRelationshipType relationshipType;

    /**
     * Microservices
     */
    @Builder.Default
    private List<Microservice> microservices = new ArrayList<>();

    /**
     * Aggregates
     */
    @Builder.Default
    private List<Aggregate> aggregates = new ArrayList<>();

    /**
     * Domain Events
     */
    @Builder.Default
    private List<DomainEventDefinition> domainEvents = new ArrayList<>();

    /**
     * Created By
     */
    private String createdBy;

    /**
     * Created Time
     */
    private Instant createdAt;

    /**
     * Updated By
     */
    private String updatedBy;

    /**
     * Updated Time
     */
    private Instant updatedAt;

}