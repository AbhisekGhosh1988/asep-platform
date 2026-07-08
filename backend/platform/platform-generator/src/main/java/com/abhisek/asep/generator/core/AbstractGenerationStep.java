package com.abhisek.asep.generator.core;

public abstract class AbstractGenerationStep
        implements GenerationStep {

    @Override
    public final void execute(
            GenerationContext context) {

        doExecute(context);

    }

    protected abstract void doExecute(
            GenerationContext context);

}