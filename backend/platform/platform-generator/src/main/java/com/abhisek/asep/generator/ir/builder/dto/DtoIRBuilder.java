package com.abhisek.asep.generator.ir.builder.dto;

import com.abhisek.asep.generator.ir.model.DtoIR;
import com.abhisek.asep.generator.model.DtoModel;

public interface DtoIRBuilder {

    DtoIR build(
            DtoModel source);

}