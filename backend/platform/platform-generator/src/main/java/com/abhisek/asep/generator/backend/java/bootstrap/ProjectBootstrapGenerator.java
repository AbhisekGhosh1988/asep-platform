package com.abhisek.asep.generator.backend.java.bootstrap;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;

/**
 * Generates the initial Java project bootstrap.
 */
public interface ProjectBootstrapGenerator {

    void generate(
            CompilerResult compilerResult,
            GenerationContext generationContext);

}