package com.abhisek.asep.generator.compiler.context;

import com.abhisek.asep.generator.compiler.diagnostic.DiagnosticCollector;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeSystem;
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
    private TypeSystem typeSystem;

    /**
     * Compilation statistics.
     */
    private CompilerStatistics statistics;

}