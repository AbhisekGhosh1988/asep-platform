package com.abhisek.asep.generator.ir.builder.specification;

import com.abhisek.asep.generator.ir.model.SpecificationIR;
import com.abhisek.asep.generator.model.SpecificationModel;

public interface SpecificationIRBuilder {

    SpecificationIR build(SpecificationModel source);

}