package com.abhisek.asep.generator.ir.builder;

import java.util.Collection;
import java.util.List;
import java.util.Objects;

/**
 * Base implementation of every IR Builder.
 *
 * Provides:
 *
 * - null validation
 * - common build flow
 * - extension hooks
 *
 * @param <S> source model
 * @param <T> target IR
 */
public abstract class AbstractIRBuilder<S, T>
        implements IRBuilder<S, T> {

    @Override
    public final T build(S source) {

        Objects.requireNonNull(
                source,
                IRBuilderConstants.NULL_SOURCE);
        validate(source);

        return doBuild(source);

    }

    /**
     * Optional validation hook.
     */
    protected void validate(S source) {
        // default no-op
    }

    /**
     * Actual mapping implementation.
     */
    protected abstract T doBuild(S source);

    protected <S, T> List<T> buildAll(
            Collection<S> source,
            IRBuilder<S, T> builder) {

        if (source == null || source.isEmpty()) {
            return List.of();
        }

        return source.stream()
                .map(builder::build)
                .toList();
    }

}