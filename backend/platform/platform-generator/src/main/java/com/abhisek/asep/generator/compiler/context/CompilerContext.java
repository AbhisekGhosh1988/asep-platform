package com.abhisek.asep.generator.compiler.context;

import com.abhisek.asep.generator.compiler.diagnostic.DiagnosticCollector;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeRegistry;
import com.abhisek.asep.generator.ir.type.TypeResolverImpl;
import com.abhisek.asep.generator.model.ProjectGenerationModel;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CompilerContext {

    /**
     * Input model.
     */
    private ProjectGenerationModel model;

    /**
     * Compiler configuration.
     */
    private CompilerConfiguration configuration;

    /**
     * Compiler options.
     */
    private CompilerOptions options;

    /**
     * Diagnostics.
     */
    private DiagnosticCollector diagnostics;

    /**
     * Symbol table.
     */
    private SymbolTable symbolTable;

    /**
     * Type system.
     */
    /**
     * Registered compiler types.
     */
    private TypeRegistry typeRegistry;
    /**
     * Compilation statistics.
     */
    private CompilerStatistics statistics;

    private CompilerResult compilerResult;

}