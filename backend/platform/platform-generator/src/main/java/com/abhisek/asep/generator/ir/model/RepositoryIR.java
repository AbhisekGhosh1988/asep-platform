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
public class RepositoryIR
        extends BaseIRNode {

    /**
     * Repository interface.
     */
    private String interfaceName;

    /**
     * Domain entity.
     */
    private String entityName;

    /**
     * Identifier type.
     */
    private String idType;

}