package com.abhisek.asep.architecture.application.design.domainevent.ai.dto;

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
public class DomainEventDefinitionAI {

    /**
     * Event name.
     */
    private String name;

    /**
     * Business meaning.
     */
    private String description;

}