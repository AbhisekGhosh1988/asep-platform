package com.abhisek.asep.generator.engine;

import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.model.AggregateModel;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompilationUnit {

    private final AggregateModel aggregate;

    private final CompilerResult compilerResult;

}