package com.abhisek.asep.architecture.application.query.mapper.impl;

import com.abhisek.asep.architecture.application.query.dto.*;
import com.abhisek.asep.architecture.application.query.mapper.ArchitectureQueryMapper;
import com.abhisek.asep.architecture.domain.model.Architecture;
import com.abhisek.asep.architecture.domain.model.BoundedContext;
import com.abhisek.asep.architecture.domain.model.Microservice;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArchitectureQueryMapperImpl implements ArchitectureQueryMapper {

    @Override
    public ArchitectureDetailsResponse toResponse(Architecture architecture, List<BoundedContext> boundedContexts, List<Microservice> microservices) {

        return ArchitectureDetailsResponse.builder().id(architecture.getId()).
                projectId(architecture.getProjectId()).name(architecture.getName()).
                description(architecture.getDescription()).style(architecture.getStyle()).
                status(architecture.getStatus()).version(architecture.getVersion()).
                boundedContexts(boundedContexts.stream().map(context ->
                        BoundedContextDetailsResponse.builder().id(context.getId()).name(context.getName()).
                                description(context.getDescription()).responsibility(context.getResponsibility()).
                                microservices(microservices.stream().filter(service ->
                                        service.getBoundedContextId().equals(context.getId())).
                                        map(service -> MicroserviceDetailsResponse.builder().
                                                id(service.getId()).name(service.getName()).
                                                description(service.getDescription()).style(service.getStyle()).
                                                build()).collect(Collectors.toList())).build()).collect(Collectors.toList())).build();

    }

}