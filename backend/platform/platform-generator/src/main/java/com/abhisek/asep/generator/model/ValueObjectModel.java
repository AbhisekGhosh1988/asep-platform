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
public class ValueObjectModel extends BaseArtifactModel {

    /**
     * Value Object attributes.
     */
    @Builder.Default
    private List<AttributeModel> attributes =
            new ArrayList<>();

}