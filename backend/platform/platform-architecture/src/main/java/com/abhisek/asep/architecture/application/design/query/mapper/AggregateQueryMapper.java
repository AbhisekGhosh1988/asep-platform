package com.abhisek.asep.architecture.application.design.query.mapper;

import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.domain.model.Aggregate;

public interface AggregateQueryMapper {

    AggregateDetailsResponse toResponse(Aggregate aggregate);

}