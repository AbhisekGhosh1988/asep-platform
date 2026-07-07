package com.abhisek.asep.architecture.application.design.attribute.query.service;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;

import java.util.List;

public interface AttributeQueryService {

    AttributeDetailsResponse getAttribute(String attributeId);

    List<AttributeDetailsResponse> getAttributes(String entityId);

}