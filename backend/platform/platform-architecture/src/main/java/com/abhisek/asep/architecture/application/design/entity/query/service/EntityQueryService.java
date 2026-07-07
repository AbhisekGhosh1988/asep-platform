package com.abhisek.asep.architecture.application.design.entity.query.service;

import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;

import java.util.List;

public interface EntityQueryService {

    EntityDetailsResponse getEntity(String entityId);

    List<EntityDetailsResponse> getEntities(String aggregateId);

}