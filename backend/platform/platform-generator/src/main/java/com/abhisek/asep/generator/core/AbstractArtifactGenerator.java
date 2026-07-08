package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.model.ArtifactGenerationRequest;
import com.abhisek.asep.generator.model.ArtifactGenerationResult;

public abstract class AbstractArtifactGenerator implements ArtifactGenerator {

    @Override
    public final ArtifactGenerationResult generate(GenerationContext context, ArtifactGenerationRequest request) {

        validate(request);

        return doGenerate(context, request);

    }

    protected void validate(ArtifactGenerationRequest request) {

    }

    protected abstract ArtifactGenerationResult doGenerate(GenerationContext context, ArtifactGenerationRequest request);

}