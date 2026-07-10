package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class DomainEventModel extends BaseArtifactModel {

    /**
     * Event payload.
     */
    @Builder.Default
    private List<AttributeModel> attributes =
            new ArrayList<>();

}