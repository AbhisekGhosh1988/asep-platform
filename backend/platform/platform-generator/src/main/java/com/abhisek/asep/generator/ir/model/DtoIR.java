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
public class DtoIR
        extends BaseIRNode {

    /**
     * Request, Response, Common, Event...
     */
    private DtoType type;

    /**
     * DTO fields.
     */
    @Builder.Default
    private List<AttributeIR> attributes =
            new ArrayList<>();

}