package com.abhisek.asep.architecture.application.design.imports.mapper;

import com.abhisek.asep.architecture.application.design.imports.dto.request.AggregateImportRequest;
import com.abhisek.asep.architecture.domain.model.Aggregate;

public interface AggregateImportMapper {

    Aggregate toAggregate(AggregateImportRequest request);

}