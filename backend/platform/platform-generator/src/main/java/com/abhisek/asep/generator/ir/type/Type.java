package com.abhisek.asep.generator.ir.type;

import lombok.Builder;
import lombok.Getter;

/**
 * Compiler type.
 */
@Getter
@Builder
public class Type {

    /**
     * Type name.
     */
    private final String name;

    /**
     * Type category.
     */
    private final TypeKind kind;

    /**
     * Fully qualified type.
     */
    private final String qualifiedName;

}