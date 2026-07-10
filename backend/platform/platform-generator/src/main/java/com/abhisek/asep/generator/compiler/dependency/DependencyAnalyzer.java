package com.abhisek.asep.generator.compiler.dependency;

import com.abhisek.asep.generator.ir.symbol.SymbolTable;

public interface DependencyAnalyzer {

    DependencyGraph analyze(
            SymbolTable symbolTable);

}