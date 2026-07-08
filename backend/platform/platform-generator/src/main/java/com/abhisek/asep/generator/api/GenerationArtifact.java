package com.abhisek.asep.generator.api;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class GenerationArtifact {

    private String id;

    private String name;

    private GenerationArtifactType type;

    private String outputPath;

}