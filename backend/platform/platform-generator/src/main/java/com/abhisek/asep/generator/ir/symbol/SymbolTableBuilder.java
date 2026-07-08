package com.abhisek.asep.generator.ir.symbol;

import com.abhisek.asep.generator.ir.model.ProjectIR;

public interface SymbolTableBuilder {

    SymbolTable build(
            ProjectIR project);

}