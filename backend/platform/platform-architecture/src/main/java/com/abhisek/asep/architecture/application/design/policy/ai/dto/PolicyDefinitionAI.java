package com.abhisek.asep.architecture.application.design.policy.ai.dto;

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
public class PolicyDefinitionAI {

    /**
     * Policy name.
     */
    private String name;

    /**
     * Business description.
     */
    private String description;

}