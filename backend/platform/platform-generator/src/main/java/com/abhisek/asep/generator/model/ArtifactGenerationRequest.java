package com.abhisek.asep.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtifactGenerationRequest {

    private ArtifactType artifactType;

    /**
     * Source design object.
     */
    private Object source;

}