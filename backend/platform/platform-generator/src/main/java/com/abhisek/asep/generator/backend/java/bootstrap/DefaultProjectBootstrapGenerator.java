package com.abhisek.asep.generator.backend.java.bootstrap;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultProjectBootstrapGenerator
        implements ProjectBootstrapGenerator {

    private final PomGenerator pomGenerator;

    private final ApplicationGenerator applicationGenerator;

    private final ApplicationYamlGenerator applicationYamlGenerator;

    private final ReadmeGenerator readmeGenerator;

    private final GitIgnoreGenerator gitIgnoreGenerator;

    @Override
    public void generate(
            CompilerResult compilerResult,
            GenerationContext generationContext) {

        log.info("Generating project bootstrap...");

        pomGenerator.generate(
                compilerResult,
                generationContext);

        applicationGenerator.generate(
                compilerResult,
                generationContext);

        applicationYamlGenerator.generate(
                compilerResult,
                generationContext);

        readmeGenerator.generate(
                compilerResult,
                generationContext);

        gitIgnoreGenerator.generate(
                compilerResult,
                generationContext);

        log.info("Project bootstrap generation completed.");

    }

}