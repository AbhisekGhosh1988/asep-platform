package com.abhisek.asep.architecture.application.design.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateAI {

    /**
     * Aggregate name.
     */
    private String name;

    /**
     * Aggregate description.
     */
    private String description;

}