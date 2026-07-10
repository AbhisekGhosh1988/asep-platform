package com.abhisek.asep.generator.ir.type;

import com.abhisek.asep.generator.ir.symbol.SymbolTable;

public interface TypeResolver {

    TypeRegistry resolve(SymbolTable symbolTable);

}