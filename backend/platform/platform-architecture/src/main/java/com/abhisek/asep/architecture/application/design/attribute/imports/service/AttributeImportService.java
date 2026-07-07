package com.abhisek.asep.architecture.application.design.attribute.imports.service;

import com.abhisek.asep.architecture.application.design.attribute.imports.dto.request.AttributeImportRequest;
import com.abhisek.asep.architecture.application.design.attribute.imports.dto.response.AttributeImportResponse;

public interface AttributeImportService {

    AttributeImportResponse importAttribute(
            AttributeImportRequest request);

}