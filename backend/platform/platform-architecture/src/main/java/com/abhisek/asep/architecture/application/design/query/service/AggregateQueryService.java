package com.abhisek.asep.architecture.application.design.query.service;

import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;

import java.util.List;

public interface AggregateQueryService {

    AggregateDetailsResponse getAggregate(String aggregateId);

    List<AggregateDetailsResponse> getAggregates(String microserviceId);

}