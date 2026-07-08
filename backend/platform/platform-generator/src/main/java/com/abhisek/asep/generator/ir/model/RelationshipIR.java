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
public class RelationshipIR
        extends BaseIRNode {

    /**
     * Source entity.
     */
    private String sourceEntity;

    /**
     * Target entity.
     */
    private String targetEntity;

    /**
     * Relationship type.
     */
    private String relationshipType;

    /**
     * Owning side.
     */
    private boolean owningSide;

}