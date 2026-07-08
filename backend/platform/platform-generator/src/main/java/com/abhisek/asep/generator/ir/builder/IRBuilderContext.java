package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.ProjectIR;
import com.abhisek.asep.generator.ir.symbol.SymbolTable;
import com.abhisek.asep.generator.ir.type.TypeSystem;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IRBuilderContext {

    /**
     * Project IR under construction.
     */
    private ProjectIR project;

    /**
     * Compiler Symbol Table.
     */
    private SymbolTable symbolTable;

    /**
     * Compiler Type System.
     */
    private TypeSystem typeSystem;

}