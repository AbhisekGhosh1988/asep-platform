package com.abhisek.asep.architecture.application.design.valueobject.ai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ValueObjectDiscoveryResponse {

    @Builder.Default
    private List<ValueObjectAI> valueObjects = new ArrayList<>();

}