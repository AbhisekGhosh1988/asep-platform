package com.abhisek.asep.generator.compiler.dependency;

import com.abhisek.asep.generator.ir.symbol.Symbol;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DependencyAnalyzerImpl
        implements DependencyAnalyzer {

    @Override
    public DependencyGraph analyze(SymbolTable symbolTable) {

        DependencyGraph graph = new DependencyGraph();

        for (Symbol symbol : symbolTable.symbols()) {

            graph.addNode(symbol.getNode());

        }

        return graph;

    }

}