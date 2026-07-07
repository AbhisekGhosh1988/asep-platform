package com.abhisek.asep.architecture.domain.model;

import com.abhisek.asep.architecture.domain.enums.CascadeType;
import com.abhisek.asep.architecture.domain.enums.FetchType;
import com.abhisek.asep.architecture.domain.enums.RelationshipType;
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
public class Relationship {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Source Entity.
     */
    private String sourceEntityId;

    /**
     * Target Entity.
     */
    private String targetEntityId;

    /**
     * Relationship type.
     */
    private RelationshipType relationshipType;

    /**
     * Java property name.
     *
     * Example:
     * orders
     * customer
     */
    private String fieldName;

    /**
     * Bidirectional mapping.
     */
    private String mappedBy;

    /**
     * Cascade rule.
     */
    private CascadeType cascadeType;

    /**
     * Fetch strategy.
     */
    private FetchType fetchType;

    /**
     * Optional association.
     */
    private Boolean optional;

    /**
     * Orphan removal.
     */
    private Boolean orphanRemoval;

    /**
     * Description.
     */
    private String description;

    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}