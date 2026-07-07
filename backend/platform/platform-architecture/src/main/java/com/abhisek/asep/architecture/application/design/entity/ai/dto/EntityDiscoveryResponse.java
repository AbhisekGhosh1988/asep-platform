package com.abhisek.asep.architecture.application.design.entity.ai.dto;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EntityDiscoveryResponse {

    @Builder.Default
    private List<EntityAI> entities = new ArrayList<>();

}