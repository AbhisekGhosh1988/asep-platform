package com.abhisek.asep.generator.backend.java.project;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;

public interface JavaProjectGenerator {

    void generate(
            CompilerResult compilerResult,
            GenerationContext context);

}