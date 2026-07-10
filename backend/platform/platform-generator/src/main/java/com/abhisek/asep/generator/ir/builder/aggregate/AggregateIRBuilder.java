package com.abhisek.asep.generator.ir.builder.aggregate;

import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.model.AggregateModel;

public interface AggregateIRBuilder {

    AggregateIR build(AggregateModel source);

}