package com.abhisek.asep.generator.ir.builder;

public abstract class AbstractIRBuilder<S, T> {

    public final T build(
            S source) {

        validate(source);

        T target = map(source);

        enrich(target);

        return target;

    }

    protected void validate(
            S source) {

        if (source == null) {

            throw new IRBuilderException(
                    "Source cannot be null.");

        }

    }

    protected abstract T map(
            S source);

    protected void enrich(
            T target) {

        // Default implementation

    }

}
