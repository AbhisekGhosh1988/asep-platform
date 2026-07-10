package com.abhisek.asep.generator.ir.symbol;

import com.abhisek.asep.generator.ir.model.AggregateIR;

/**
 * Builds the compiler symbol table from the IR.
 */
public interface SymbolTableBuilder {

    SymbolTable build(AggregateIR aggregate);

}