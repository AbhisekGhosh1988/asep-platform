package com.abhisek.asep.generator.ir.builder.mapper;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.MapperIR;
import com.abhisek.asep.generator.model.MapperModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultMapperIRBuilder extends BaseArtifactIRBuilder<MapperModel, MapperIR> implements MapperIRBuilder {

    @Override
    protected void validate(MapperModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {

            throw new IllegalArgumentException("Mapper name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Mapper";

    }

    @Override
    protected MapperIR doBuild(MapperModel source) {

        return MapperIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).entity(source.getEntity()).dto(source.getDto()).build();

    }

}