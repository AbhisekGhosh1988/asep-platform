package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class SpecificationModel
        extends BaseArtifactModel {

    /**
     * Entity this specification validates.
     */
    private String targetEntity;

}