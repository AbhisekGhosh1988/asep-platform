package com.abhisek.asep.architecture.application.design.entity.imports.mapper;

import com.abhisek.asep.architecture.application.design.entity.imports.dto.request.EntityImportRequest;
import com.abhisek.asep.architecture.domain.model.Entity;

public interface EntityImportMapper {

    Entity toEntity(EntityImportRequest request);

}