package com.abhisek.asep.architecture.application.design.attribute.ai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AttributeDiscoveryResponse {

    @Builder.Default
    private List<AttributeAI> attributes =
            new ArrayList<>();

}