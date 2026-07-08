package com.abhisek.asep.generator.compiler.context;

import com.abhisek.asep.generator.compiler.diagnostic.DiagnosticCollector;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.DefaultTypeSystem;
import com.abhisek.asep.generator.model.ProjectGenerationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CompilerContextFactory {

    private final DefaultTypeSystem typeSystem;

    private final DiagnosticCollector diagnostics;

    public CompilerContext create(ProjectGenerationModel model) {

        return CompilerContext.builder()
                .model(model)
                .configuration(
                        CompilerConfiguration.builder()
                                .javaVersion("21")
                                .springBootVersion("3.5.0")
                                .outputEncoding("UTF-8")
                                .build())
                .options(
                        CompilerOptions.builder()
                                .build())
                .diagnostics(diagnostics)
                .symbolTable(new SymbolTable())
                .typeSystem(typeSystem)
                .statistics(
                        CompilerStatistics.builder()
                                .startedAt(System.currentTimeMillis())
                                .build())
                .build();

    }

}