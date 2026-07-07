package com.abhisek.asep.architecture.application.design.valueobject.imports.service;

import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.request.ValueObjectImportRequest;
import com.abhisek.asep.architecture.application.design.valueobject.imports.dto.response.ValueObjectImportResponse;

public interface ValueObjectImportService {

    ValueObjectImportResponse importValueObject(
            ValueObjectImportRequest request);

}