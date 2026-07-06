package com.abhisek.asep.architecture.application.mapper;

import com.abhisek.asep.architecture.application.dto.response.ArchitectureResponse;
import com.abhisek.asep.architecture.domain.model.Architecture;

public interface ArchitectureApplicationMapper {

    ArchitectureResponse toResponse(Architecture architecture);

}