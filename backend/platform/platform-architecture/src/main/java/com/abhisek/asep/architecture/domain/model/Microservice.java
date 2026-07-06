package com.abhisek.asep.architecture.domain.model;

import com.abhisek.asep.architecture.domain.enums.ArchitectureStyle;
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
public class Microservice {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent bounded context.
     */
    private String boundedContextId;

    /**
     * Microservice name.
     */
    private String name;

    /**
     * Description.
     */
    private String description;

    /**
     * Suggested architecture style.
     */
    private ArchitectureStyle style;

    /**
     * Audit fields.
     */
    private String createdBy;

    private Instant createdAt;

    private String updatedBy;

    private Instant updatedAt;

}