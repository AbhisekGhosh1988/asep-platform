package com.abhisek.asep.architecture.application.design.ai.dto;

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
public class AggregateDiscoveryResponse {

    @Builder.Default
    private List<AggregateAI> aggregates =
            new ArrayList<>();

}