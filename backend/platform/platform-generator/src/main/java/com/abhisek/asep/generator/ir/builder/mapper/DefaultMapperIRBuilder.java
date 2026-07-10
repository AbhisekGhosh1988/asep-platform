package com.abhisek.asep.generator.ir.builder.mapper;

import com.abhisek.asep.generator.ir.model.MapperIR;
import com.abhisek.asep.generator.model.MapperModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapperIRBuilder implements MapperIRBuilder {

    @Override
    public MapperIR build(MapperModel source) {

        return MapperIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).build();

    }

}