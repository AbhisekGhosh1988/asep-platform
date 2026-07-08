package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.EntityIR;

import java.util.List;

public interface EntityIRBuilder {

    List<EntityIR> build(
            String aggregateId);

}