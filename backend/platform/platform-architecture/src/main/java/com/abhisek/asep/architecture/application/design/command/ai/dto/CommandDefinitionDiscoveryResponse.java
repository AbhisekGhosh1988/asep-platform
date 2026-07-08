package com.abhisek.asep.architecture.application.design.command.ai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommandDefinitionDiscoveryResponse {

    @Builder.Default
    private List<CommandDefinitionAI> commands =
            new ArrayList<>();

}