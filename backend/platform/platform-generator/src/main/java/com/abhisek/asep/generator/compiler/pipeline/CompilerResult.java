package com.abhisek.asep.generator.compiler.pipeline;

import com.abhisek.asep.generator.compiler.dependency.DependencyGraph;
import com.abhisek.asep.generator.compiler.planner.GenerationPlan;
import com.abhisek.asep.generator.compiler.semantic.SemanticValidationResult;
import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeRegistry;
import lombok.Builder;
import lombok.Getter;

/**
 * Final output produced by the compiler.
 */
@Getter
@Builder
public class CompilerResult {

    /**
     * Compiled aggregate.
     */
    private final AggregateIR aggregate;

    /**
     * Symbol table.
     */
    private final SymbolTable symbolTable;

    /**
     * Registered compiler types.
     */
    private final TypeRegistry typeRegistry;

    /**
     * Semantic validation result.
     */
    private final SemanticValidationResult validationResult;

    /**
     * Dependency graph.
     */
    private final DependencyGraph dependencyGraph;

    /**
     * Ordered generation plan.
     */
    private final GenerationPlan generationPlan;

}