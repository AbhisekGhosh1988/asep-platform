package com.abhisek.asep.generator.ir.symbol;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class Symbol {

    /**
     * Unique Id.
     */
    private String id;

    /**
     * Symbol name.
     */
    private String name;

    /**
     * Symbol type.
     */
    private SymbolType type;

    /**
     * Fully qualified name.
     */
    private String qualifiedName;

}