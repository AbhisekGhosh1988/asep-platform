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
public class ValueObjectIR
        extends BaseIRNode {

    /**
     * Value object attributes.
     */
    @Builder.Default
    private List<AttributeIR> attributes =
            new ArrayList<>();

}