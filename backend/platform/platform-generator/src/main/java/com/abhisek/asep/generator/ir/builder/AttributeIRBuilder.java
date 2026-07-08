package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.AttributeIR;

import java.util.List;

public interface AttributeIRBuilder {

    List<AttributeIR> build(
            String entityId);

}