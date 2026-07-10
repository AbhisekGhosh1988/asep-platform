package com.abhisek.asep.generator.ir.builder.mapper;

import com.abhisek.asep.generator.ir.model.MapperIR;
import com.abhisek.asep.generator.model.MapperModel;

public interface MapperIRBuilder {

    MapperIR build(
            MapperModel source);

}