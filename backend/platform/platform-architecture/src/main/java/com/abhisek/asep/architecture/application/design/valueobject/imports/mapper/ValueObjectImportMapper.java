package com.abhisek.asep.architecture.application.design.valueobject.imports.mapper;

import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.request.ValueObjectImportRequest;
import com.abhisek.asep.architecture.domain.model.ValueObject;

public interface ValueObjectImportMapper {

    ValueObject toValueObject(
            ValueObjectImportRequest request);

}