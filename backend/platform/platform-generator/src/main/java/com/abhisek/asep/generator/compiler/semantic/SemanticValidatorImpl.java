package com.abhisek.asep.generator.compiler.semantic;

import com.abhisek.asep.generator.ir.symbol.Symbol;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeRegistry;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * Compiler semantic validator.
 */
@Component
@RequiredArgsConstructor
public class SemanticValidatorImpl implements SemanticValidator {

    @Override
    public SemanticValidationResult validate(SymbolTable symbolTable, TypeRegistry typeRegistry) {

        SemanticValidationResult result = new SemanticValidationResult();

        for (Symbol symbol : symbolTable.symbols()) {

            if (typeRegistry.resolve(symbol.getName()).isEmpty()) {

                result.addError(SemanticError.builder().code("SEM-001").message("Unresolved type").target(symbol.getName()).build());

            }

        }

        return result;

    }

}