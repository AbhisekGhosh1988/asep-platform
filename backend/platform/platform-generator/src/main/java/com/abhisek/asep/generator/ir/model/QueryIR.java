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
public class QueryIR
        extends BaseIRNode {

    /**
     * Handler class.
     */
    private String handler;

    /**
     * Response DTO.
     */
    private String responseType;

}