package com.abhisek.asep.generator.core;


import java.util.List;

public interface GenerationPipeline {

    void execute(GenerationContext context);

    List<GenerationStep> getSteps();

}