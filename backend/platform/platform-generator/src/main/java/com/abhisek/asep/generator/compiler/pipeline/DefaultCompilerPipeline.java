package com.abhisek.asep.generator.compiler.pipeline;

import com.abhisek.asep.generator.compiler.dependency.DependencyAnalyzer;
import com.abhisek.asep.generator.compiler.dependency.DependencyGraph;
import com.abhisek.asep.generator.compiler.planner.GenerationPlan;
import com.abhisek.asep.generator.compiler.planner.GenerationPlanner;
import com.abhisek.asep.generator.compiler.resolver.UseCaseDependencyResolver;
import com.abhisek.asep.generator.compiler.semantic.SemanticValidationResult;
import com.abhisek.asep.generator.compiler.semantic.SemanticValidator;
import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.symbol.SymbolTableBuilder;
import com.abhisek.asep.generator.ir.type.TypeRegistry;
import com.abhisek.asep.generator.ir.type.TypeResolver;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultCompilerPipeline implements CompilerPipeline {

    private final SymbolTableBuilder symbolTableBuilder;

    private final TypeResolver typeResolver;

    private final SemanticValidator semanticValidator;

    private final DependencyAnalyzer dependencyAnalyzer;

    private final GenerationPlanner generationPlanner;
    private final UseCaseDependencyResolver
            useCaseDependencyResolver;

    @Override
    public CompilerResult compile(AggregateIR aggregateIR) {

        SymbolTable symbolTable = symbolTableBuilder.build(aggregateIR);

        TypeRegistry typeRegistry = typeResolver.resolve(symbolTable);

        SemanticValidationResult validationResult = semanticValidator.validate(symbolTable, typeRegistry);
        useCaseDependencyResolver.resolve(
                aggregateIR);
        DependencyGraph dependencyGraph = dependencyAnalyzer.analyze(symbolTable);

        GenerationPlan generationPlan = generationPlanner.createPlan(dependencyGraph);

        return CompilerResult.builder().aggregate(aggregateIR).symbolTable(symbolTable).typeRegistry(typeRegistry).validationResult(validationResult).dependencyGraph(dependencyGraph).generationPlan(generationPlan).build();

    }

}