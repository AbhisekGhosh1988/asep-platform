package com.abhisek.asep.architecture.application.design.command.ai.dto;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandDefinitionAI {

    /**
     * Command name.
     */
    private String name;

    /**
     * Business intent.
     */
    private String description;

}