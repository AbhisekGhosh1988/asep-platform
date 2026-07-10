package com.abhisek.asep.generator.ir.symbol;

import com.abhisek.asep.generator.ir.model.BaseIRNode;
import lombok.Builder;
import lombok.Getter;

/**
 * Compiler symbol.
 *
 * A symbol represents one named IR element registered
 * during compiler analysis.
 */
@Getter
@Builder
public class Symbol {

    /**
     * Symbol name.
     */
    private final String name;

    /**
     * Symbol type.
     */
    private final SymbolKind kind;

    /**
     * Source IR node.
     */
    private final BaseIRNode node;

}