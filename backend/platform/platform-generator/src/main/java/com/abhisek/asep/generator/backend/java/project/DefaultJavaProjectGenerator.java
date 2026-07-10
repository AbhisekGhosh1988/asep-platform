package com.abhisek.asep.generator.backend.java.project;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.java.bootstrap.ProjectBootstrapGenerator;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultJavaProjectGenerator
        implements JavaProjectGenerator {

    private final ProjectBootstrapGenerator projectBootstrapGenerator;

    @Override
    public void generate(
            CompilerResult compilerResult,
            GenerationContext context) {

        projectBootstrapGenerator.generate(
                compilerResult,
                context);

    }

}