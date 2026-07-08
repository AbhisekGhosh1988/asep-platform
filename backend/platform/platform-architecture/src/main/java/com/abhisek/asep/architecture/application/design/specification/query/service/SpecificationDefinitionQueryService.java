package com.abhisek.asep.architecture.application.design.specification.query.service;

import com.abhisek.asep.architecture.application.design.specification.query.dto.SpecificationDefinitionDetailsResponse;

import java.util.List;

public interface SpecificationDefinitionQueryService {

    SpecificationDefinitionDetailsResponse getSpecification(
            String specificationId);

    List<SpecificationDefinitionDetailsResponse> getSpecifications(
            String aggregateId);

}