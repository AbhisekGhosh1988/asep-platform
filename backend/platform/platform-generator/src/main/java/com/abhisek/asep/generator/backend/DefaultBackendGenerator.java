package com.abhisek.asep.generator.backend;

import com.abhisek.asep.generator.backend.context.GenerationContext;
import com.abhisek.asep.generator.backend.java.project.JavaProjectGenerator;
import com.abhisek.asep.generator.backend.spi.ArtifactGenerator;
import com.abhisek.asep.generator.backend.spi.GeneratorRegistry;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.compiler.planner.GenerationTask;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class DefaultBackendGenerator implements BackendGenerator {

    private final GeneratorRegistry generatorRegistry;

    private final JavaProjectGenerator javaProjectGenerator;

    private final GenerationContext generationContext;

    @Override
    public BackendGenerationResult generate(CompilerResult compilerResult) {

        log.info("Starting backend generation...");

        /*
         * Generate Maven project structure first.
         */
        javaProjectGenerator.generate(compilerResult, generationContext);

        /*
         * Generate artifacts in compiler order.
         */
        for (GenerationTask step : compilerResult.getGenerationPlan().getTasks()) {

            generatorRegistry.find(step.getArtifactType()).ifPresent(generator -> generateArtifact(generator, step, compilerResult));

        }

        log.info("Backend generation completed.");

        return BackendGenerationResult.builder().build();

    }

    private void generateArtifact(ArtifactGenerator generator, GenerationTask step, CompilerResult compilerResult) {

        log.debug("Generating {} : {}", step.getArtifactType(), step.getName());

        generator.generate(step, compilerResult, generationContext);
    }

}