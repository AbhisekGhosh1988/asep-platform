package com.abhisek.asep.generator.core;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultGenerationPipeline
        implements GenerationPipeline {

    private final List<GenerationStep> steps;

    @Override
    public void execute(
            GenerationContext context) {

        for (GenerationStep step : steps) {

            step.execute(context);

        }

    }

    @Override
    public List<GenerationStep> getSteps() {

        return steps;

    }

}