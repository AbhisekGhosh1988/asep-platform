package com.abhisek.asep.architecture.application.design.specification.ai.dto;

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
public class SpecificationDefinitionDiscoveryResponse {

    @Builder.Default
    private List<SpecificationDefinitionAI> specifications =
            new ArrayList<>();

}