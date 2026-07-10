package com.abhisek.asep.generator.ir.builder.factory;

import com.abhisek.asep.generator.ir.model.FactoryIR;
import com.abhisek.asep.generator.model.FactoryModel;

public interface FactoryIRBuilder {

    FactoryIR build(FactoryModel source);

}