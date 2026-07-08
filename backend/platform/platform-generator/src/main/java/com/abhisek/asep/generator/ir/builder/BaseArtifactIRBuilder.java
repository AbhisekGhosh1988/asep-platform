package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.BaseIRNode;

public abstract class BaseArtifactIRBuilder<S, T>
        extends AbstractIRBuilder<S, T>
        implements IRBuilder<S, T> {

    @Override
    protected void enrich(
            T target) {

        if (target == null) {
            return;
        }

    }

}