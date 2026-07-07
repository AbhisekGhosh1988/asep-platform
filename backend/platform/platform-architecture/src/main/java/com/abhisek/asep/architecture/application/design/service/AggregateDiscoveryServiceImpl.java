package com.abhisek.asep.architecture.application.design.service;

import com.abhisek.asep.architecture.application.design.ai.dto.AggregateDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.ai.workflow.AggregateDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.query.dto.ArchitectureDetailsResponse;
import com.abhisek.asep.architecture.application.query.service.ArchitectureQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AggregateDiscoveryServiceImpl implements AggregateDiscoveryService {

    private final ArchitectureQueryService architectureQueryService;

    private final AggregateDiscoveryWorkflow workflow;

    @Override
    public AggregateDiscoveryResponse discover(String architectureId) {

        ArchitectureDetailsResponse architecture = architectureQueryService.getArchitecture(architectureId);

        return workflow.execute(buildPrompt(architecture));

    }

    private String buildPrompt(ArchitectureDetailsResponse architecture) {

        StringBuilder builder = new StringBuilder();

        builder.append("Architecture\n\n");

        builder.append("Name: ").append(architecture.getName()).append("\n\n");

        architecture.getBoundedContexts().forEach(context -> {

            builder.append("Bounded Context: ").append(context.getName()).append("\n");

            builder.append("Responsibility: ").append(context.getResponsibility()).append("\n");

            context.getMicroservices().forEach(service ->

                    builder.append("Microservice: ").append(service.getName()).append("\n"));

            builder.append("\n");

        });

        return builder.toString();

    }

}