package com.abhisek.asep.generator.backend.java.bootstrap;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;

public interface ReadmeGenerator {

    void generate(
            CompilerResult compilerResult,
            GenerationContext generationContext);

}