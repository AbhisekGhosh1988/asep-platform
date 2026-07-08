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
public class CommandIR
        extends BaseIRNode {

    /**
     * Handler class.
     */
    private String handler;

    /**
     * Request DTO.
     */
    private String requestType;

    /**
     * Response DTO.
     */
    private String responseType;

}