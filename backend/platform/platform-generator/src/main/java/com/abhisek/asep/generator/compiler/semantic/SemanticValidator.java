package com.abhisek.asep.generator.compiler.semantic;

import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeRegistry;

public interface SemanticValidator {

    SemanticValidationResult validate(
            SymbolTable symbolTable,
            TypeRegistry typeRegistry);

}