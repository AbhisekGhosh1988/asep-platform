package com.abhisek.asep.architecture.application.design.entity.query.mapper;

import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.domain.model.Entity;

public interface EntityQueryMapper {

    EntityDetailsResponse toResponse(Entity entity);

}