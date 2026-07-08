package com.abhisek.asep.generator.ir.builder;

/**
 * Generic contract for transforming a generation model
 * into an Intermediate Representation (IR).
 *
 * @param <S> Source model
 * @param <T> Target IR
 */
public interface IRBuilder<S, T> {

    /**
     * Builds an IR node from the supplied source model.
     *
     * @param source source model
     * @return generated IR
     */
    T build(S source);

}