package com.abhisek.asep.generator.ir.type;

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
public class TypeReference {

    /**
     * Simple name.
     */
    private String name;

    /**
     * Fully qualified type.
     */
    private String qualifiedName;

    /**
     * Category.
     */
    private TypeCategory category;

    /**
     * Generic.
     */
    private boolean generic;

}