package com.abhisek.asep.architecture.application.design.entity.imports.service;

import com.abhisek.asep.architecture.application.design.entity.imports.dto.request.EntityImportRequest;
import com.abhisek.asep.architecture.application.design.entity.imports.dto.response.EntityImportResponse;

public interface EntityImportService {

    EntityImportResponse importEntity(
            EntityImportRequest request);

}