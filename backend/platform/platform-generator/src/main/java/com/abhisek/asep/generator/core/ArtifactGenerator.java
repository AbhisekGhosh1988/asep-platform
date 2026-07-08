package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.model.ArtifactGenerationRequest;
import com.abhisek.asep.generator.model.ArtifactGenerationResult;
import com.abhisek.asep.generator.model.ArtifactType;

public interface ArtifactGenerator {

    ArtifactType getArtifactType();

    ArtifactGenerationResult generate(GenerationContext context, ArtifactGenerationRequest request);

}