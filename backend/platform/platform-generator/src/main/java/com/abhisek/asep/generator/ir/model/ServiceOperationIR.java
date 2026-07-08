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
public class ServiceOperationIR
        extends BaseIRNode {

    /**
     * Return type.
     */
    private String returnType;

    /**
     * Parameters.
     */
    @Builder.Default
    private List<ParameterIR> parameters =
            new ArrayList<>();

}