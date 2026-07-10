package com.abhisek.asep.generator.ir.builder.dto;

import com.abhisek.asep.generator.ir.model.AttributeIR;
import com.abhisek.asep.generator.ir.model.DtoIR;
import com.abhisek.asep.generator.model.AttributeModel;
import com.abhisek.asep.generator.model.DtoModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultDtoIRBuilder implements DtoIRBuilder {

    @Override
    public DtoIR build(DtoModel source) {

        return DtoIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).type(com.abhisek.asep.generator.ir.model.DtoType.valueOf(source.getType().name())).attributes(source.getAttributes().stream().map(this::toAttributeIR).collect(Collectors.toList())).build();

    }

    private AttributeIR toAttributeIR(AttributeModel source) {

        return AttributeIR.builder().name(source.getName()).dataType(source.getDataType()).nullable(source.isNullable()).
                identifier(source.isIdentifier()).unique(true).build();

    }

}