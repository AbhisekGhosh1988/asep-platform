package com.abhisek.asep.generator.compiler.pipeline;

import com.abhisek.asep.generator.ir.model.AggregateIR;

public interface CompilerPipeline {

    CompilerResult compile(AggregateIR aggregateIR);

}