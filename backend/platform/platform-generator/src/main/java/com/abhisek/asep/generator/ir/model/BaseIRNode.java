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
public abstract class BaseIRNode {

    /**
     * Unique identifier.
     */
    private String id;

    /**
     * Business name.
     */
    private String name;

    /**
     * Description.
     */
    private String description;

}