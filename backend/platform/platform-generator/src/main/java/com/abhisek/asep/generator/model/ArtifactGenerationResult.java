package com.abhisek.asep.generator.model;

import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ArtifactGenerationResult {

    private ArtifactType artifactType;

    private String generatedFile;

}