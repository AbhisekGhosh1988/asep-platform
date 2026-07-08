package com.abhisek.asep.generator.ir.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class EntityIR
        extends BaseIRNode {

    /**
     * Attributes.
     */

    @Builder.Default
    private List<AttributeIR> attributes =
            new ArrayList<>();

    /**
     * Relationships.
     */
    @Builder.Default
    private List<RelationshipIR> relationships =
            new ArrayList<>();

}