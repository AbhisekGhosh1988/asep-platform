package com.abhisek.asep.architecture.application.design.policy.ai.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PolicyDefinitionDiscoveryResponse {

    @Builder.Default
    private List<PolicyDefinitionAI> policies =
            new ArrayList<>();

}