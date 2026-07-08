package com.abhisek.asep.architecture.application.design.factory.query.service;

import com.abhisek.asep.architecture.application.design.factory.query.dto.FactoryDefinitionDetailsResponse;

import java.util.List;

public interface FactoryDefinitionQueryService {

    FactoryDefinitionDetailsResponse getFactory(
            String factoryId);

    List<FactoryDefinitionDetailsResponse> getFactories(
            String aggregateId);

}