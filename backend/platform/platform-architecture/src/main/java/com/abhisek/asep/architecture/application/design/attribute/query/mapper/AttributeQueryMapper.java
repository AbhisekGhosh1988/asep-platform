package com.abhisek.asep.architecture.application.design.attribute.query.mapper;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.domain.model.Attribute;

public interface AttributeQueryMapper {

    AttributeDetailsResponse toResponse(Attribute attribute);

}