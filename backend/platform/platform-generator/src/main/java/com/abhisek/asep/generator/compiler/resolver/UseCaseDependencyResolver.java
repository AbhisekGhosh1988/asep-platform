package com.abhisek.asep.generator.compiler.resolver;

import com.abhisek.asep.generator.ir.model.AggregateIR;

public interface UseCaseDependencyResolver {

    void resolve(
            AggregateIR aggregate);

}