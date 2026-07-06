package com.abhisek.asep.architecture.application.query.mapper;

import com.abhisek.asep.architecture.application.query.dto.ArchitectureDetailsResponse;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.domain.model.Microservice;

import java.util.List;

public interface ArchitectureQueryMapper {

    ArchitectureDetailsResponse toResponse(
            Architecture architecture,
            List<BoundedContext> boundedContexts,
            List<Microservice> microservices);

}