package com.abhisek.asep.generator.ir.model;

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
public class AttributeIR
        extends BaseIRNode {

    /**
     * Java data type.
     */
    private String dataType;

    /**
     * Is primary identifier.
     */
    private boolean identifier;

    /**
     * Nullable.
     */
    private boolean nullable;

    /**
     * Unique.
     */
    private boolean unique;

    /**
     * Collection.
     */
    private boolean collection;

    /**
     * Default value.
     */
    private String defaultValue;

}