package com.abhisek.asep.architecture.application.design.imports.service;

import com.abhisek.asep.architecture.application.design.imports.dto.request.AggregateImportRequest;
import com.abhisek.asep.architecture.application.design.imports.dto.response.AggregateImportResponse;

public interface AggregateImportService {

    AggregateImportResponse importAggregate(
            AggregateImportRequest request);

}