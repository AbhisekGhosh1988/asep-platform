package com.abhisek.asep.generator.ir.builder;

public interface IRBuilder<S, T> {

    T build(
            S source);

}