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
public class EntityModel
        extends BaseArtifactModel {

    @Builder.Default
    private List<AttributeModel> attributes =
            new ArrayList<>();

    @Builder.Default
    private List<RelationshipModel> relationships =
            new ArrayList<>();

}