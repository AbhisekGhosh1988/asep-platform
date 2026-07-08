package com.abhisek.asep.architecture.application.design.specification.imports.service;

import com.abhisek.asep.architecture.application.design.specification.imports.dto.request.SpecificationDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.specification.imports.dto.response.SpecificationDefinitionImportResponse;

public interface SpecificationDefinitionImportService {

    SpecificationDefinitionImportResponse importSpecification(
            SpecificationDefinitionImportRequest request);

}