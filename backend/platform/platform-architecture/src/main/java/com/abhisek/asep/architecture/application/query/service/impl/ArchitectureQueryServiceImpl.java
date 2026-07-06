package com.abhisek.asep.architecture.application.query.service.impl;

import com.abhisek.asep.architecture.application.query.dto.ArchitectureDetailsResponse;
import com.abhisek.asep.architecture.application.query.mapper.ArchitectureQueryMapper;
import com.abhisek.asep.architecture.application.query.service.ArchitectureQueryService;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.domain.model.Microservice;
import com.abhisek.asep.architecture.domain.repository.ArchitectureRepository;
import com.abhisek.asep.architecture.domain.repository.BoundedContextRepository;
import com.abhisek.asep.architecture.domain.repository.MicroserviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ArchitectureQueryServiceImpl implements ArchitectureQueryService {

    private final ArchitectureRepository architectureRepository;

    private final BoundedContextRepository boundedContextRepository;

    private final MicroserviceRepository microserviceRepository;

    private final ArchitectureQueryMapper mapper;

    @Override
    public ArchitectureDetailsResponse getArchitecture(String architectureId) {

        Architecture architecture = architectureRepository.findById(architectureId).orElseThrow(() -> new IllegalArgumentException("Architecture not found: " + architectureId));

        List<BoundedContext> boundedContexts = boundedContextRepository.findByArchitectureId(architectureId);

        List<Microservice> microservices = boundedContexts.stream().flatMap(context -> microserviceRepository.findByBoundedContextId(context.getId()).stream()).toList();

        return mapper.toResponse(architecture, boundedContexts, microservices);

    }

}