package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.model.BaseArtifactModel;

public abstract class BaseArtifactIRBuilder<S extends BaseArtifactModel, T>
        extends AbstractIRBuilder<S, T> {

    @Override
    protected void validate(S source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IRBuilderException(
                    getArtifactType() + " name cannot be null or blank.");

        }

    }

    /**
     * Used for validation messages.
     */
    protected abstract String getArtifactType();

}