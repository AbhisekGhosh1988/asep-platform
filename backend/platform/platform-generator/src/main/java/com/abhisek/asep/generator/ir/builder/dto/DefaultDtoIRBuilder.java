package com.abhisek.asep.generator.ir.builder.dto;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.builder.attribute.AttributeIRBuilder;
import com.abhisek.asep.generator.ir.model.DtoIR;
import com.abhisek.asep.generator.model.DtoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultDtoIRBuilder extends BaseArtifactIRBuilder<DtoModel, DtoIR> implements DtoIRBuilder {

    private final AttributeIRBuilder attributeIRBuilder;

    @Override
    protected void validate(DtoModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {

            throw new IllegalArgumentException("DTO name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "DTO";

    }

    @Override
    protected DtoIR doBuild(DtoModel source) {

        DtoIR dto = DtoIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).type(source.getType()).build();

        source.getAttributes().forEach(attribute -> dto.getAttributes().add(attributeIRBuilder.build(attribute)));

        return dto;

    }

}