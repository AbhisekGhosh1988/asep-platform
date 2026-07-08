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
public class DomainServiceIR
        extends BaseIRNode {

    /**
     * Service operations.
     */
    @Builder.Default
    private List<ServiceOperationIR> operations =
            new ArrayList<>();

}