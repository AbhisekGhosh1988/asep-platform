package com.abhisek.asep.architecture.application.design.valueobject.query.mapper.impl;

import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;
import com.abhisek.asep.architecture.application.design.valueobject.query.mapper.ValueObjectQueryMapper;
import com.abhisek.asep.architecture.domain.model.ValueObject;
import org.springframework.stereotype.Component;

@Component
public class ValueObjectQueryMapperImpl implements ValueObjectQueryMapper {

    @Override
    public ValueObjectDetailsResponse toResponse(ValueObject valueObject) {

        if (valueObject == null) {
            return null;
        }

        return ValueObjectDetailsResponse.builder().id(valueObject.getId()).aggregateId(valueObject.getAggregateId()).name(valueObject.getName()).description(valueObject.getDescription()).immutable(valueObject.getImmutable()).build();

    }

}