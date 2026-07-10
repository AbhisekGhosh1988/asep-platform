package com.abhisek.asep.generator.ir.builder.usecase;

import com.abhisek.asep.generator.ir.model.UseCaseIR;
import com.abhisek.asep.generator.ir.model.UseCaseModel;

public interface UseCaseIRBuilder {

    UseCaseIR build(
            UseCaseModel source);

}