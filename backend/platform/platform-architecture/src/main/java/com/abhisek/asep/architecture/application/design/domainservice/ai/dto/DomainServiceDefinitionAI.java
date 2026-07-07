package com.abhisek.asep.architecture.application.design.domainservice.ai.dto;

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
public class DomainServiceDefinitionAI {

    /**
     * Service name.
     */
    private String name;

    /**
     * Business responsibility.
     */
    private String description;

}