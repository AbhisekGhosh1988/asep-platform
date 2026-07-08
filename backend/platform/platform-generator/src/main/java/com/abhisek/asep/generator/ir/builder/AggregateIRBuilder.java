package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.AggregateIR;

import java.util.List;

public interface AggregateIRBuilder {

    List<AggregateIR> build(
            String projectId);

}