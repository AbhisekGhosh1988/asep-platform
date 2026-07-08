package com.abhisek.asep.architecture.application.design.factory.imports.service;

import com.abhisek.asep.architecture.application.design.factory.imports.dto.request.FactoryDefinitionImportRequest;
import com.abhisek.asep.architecture.application.design.factory.imports.dto.response.FactoryDefinitionImportResponse;

public interface FactoryDefinitionImportService {

    FactoryDefinitionImportResponse importFactory(
            FactoryDefinitionImportRequest request);

}