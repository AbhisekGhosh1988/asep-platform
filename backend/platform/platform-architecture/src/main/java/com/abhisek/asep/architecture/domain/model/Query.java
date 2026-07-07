package com.abhisek.asep.architecture.domain.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Query {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Parent Aggregate.
     */
    private String aggregateId;

    /**
     * Query name.
     */
    private String name;

    /**
     * Description.
     */
    private String description;

}