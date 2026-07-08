package com.abhisek.asep.generator.core;


public interface GenerationStep {

    String getName();

    void execute(GenerationContext context);

}