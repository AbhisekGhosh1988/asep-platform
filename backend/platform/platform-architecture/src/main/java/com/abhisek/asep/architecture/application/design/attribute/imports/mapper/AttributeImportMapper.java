package com.abhisek.asep.architecture.application.design.attribute.imports.mapper;

import com.abhisek.asep.architecture.application.design.attribute.imports.dto.request.AttributeImportRequest;
import com.abhisek.asep.architecture.domain.model.Attribute;

public interface AttributeImportMapper {

    Attribute toAttribute(AttributeImportRequest request);

}