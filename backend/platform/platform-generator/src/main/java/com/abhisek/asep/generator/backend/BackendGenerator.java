package com.abhisek.asep.generator.backend;

import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;

/**
 * Generates backend artifacts from compiler output.
 */
public interface BackendGenerator {

    /**
     * Generate complete backend.
     *
     * @param compilerResult compiler output
     * @return generation result
     */
    BackendGenerationResult generate(
            CompilerResult compilerResult);

}