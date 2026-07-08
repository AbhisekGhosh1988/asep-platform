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
public class FactoryIR
        extends BaseIRNode {

    /**
     * Factory methods.
     */
    @Builder.Default
    private List<ServiceOperationIR> methods =
            new ArrayList<>();

}