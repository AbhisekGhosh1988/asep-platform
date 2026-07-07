package com.abhisek.asep.architecture.application.design.valueobject.imports.mapper.impl;

import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.request.ValueObjectImportRequest;
import com.abhisek.asep.architecture.application.design.valueobject.imports.mapper.ValueObjectImportMapper;
import com.abhisek.asep.architecture.domain.model.ValueObject;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectImportMapperImpl implements ValueObjectImportMapper {

    @Override
    public ValueObject toValueObject(ValueObjectImportRequest request) {

        return ValueObject.builder().aggregateId(request.getAggregateId()).name(request.getName()).description(request.getDescription()).immutable(request.getImmutable()).build();

    }

}