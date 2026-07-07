package com.abhisek.asep.architecture.application.design.relationship.ai.dto;

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
public class RelationshipDiscoveryResponse {

    @Builder.Default
    private List<RelationshipAI> relationships =
            new ArrayList<>();

}