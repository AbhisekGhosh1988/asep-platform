package com.abhisek.asep.generator.backend.spi;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.compiler.planner.GenerationTask;

/**
 * Base contract for every backend artifact generator.
 */
public interface ArtifactGenerator {

    /**
     * Supported artifact.
     */
    ArtifactType getArtifactType();

    /**
     * Generates source.
     */
    void generate(
            GenerationTask step,
            CompilerResult compilerResult,
            GenerationContext generationContext);

}