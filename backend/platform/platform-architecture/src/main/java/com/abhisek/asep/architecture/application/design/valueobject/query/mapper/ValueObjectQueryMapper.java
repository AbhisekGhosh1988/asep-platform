package com.abhisek.asep.architecture.application.design.valueobject.query.mapper;

import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;
import com.abhisek.asep.architecture.domain.model.ValueObject;

public interface ValueObjectQueryMapper {

    ValueObjectDetailsResponse toResponse(
            ValueObject valueObject);

}