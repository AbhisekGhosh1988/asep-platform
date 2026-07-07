package com.abhisek.asep.architecture.application.design.valueobject.query.service;

import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;

import java.util.List;

public interface ValueObjectQueryService {

    ValueObjectDetailsResponse getValueObject(
            String valueObjectId);

    List<ValueObjectDetailsResponse> getValueObjects(
            String aggregateId);

}