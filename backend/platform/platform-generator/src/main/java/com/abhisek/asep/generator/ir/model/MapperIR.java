package com.abhisek.asep.generator.ir.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class MapperIR
        extends BaseIRNode {

    /**
     * Entity class.
     */
    private String entity;

    /**
     * DTO class.
     */
    private String dto;

}