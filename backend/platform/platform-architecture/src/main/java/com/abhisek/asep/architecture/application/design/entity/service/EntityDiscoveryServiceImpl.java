package com.abhisek.asep.architecture.application.design.entity.service;

import com.abhisek.asep.architecture.application.design.entity.ai.dto.EntityDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.entity.ai.workflow.EntityDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EntityDiscoveryServiceImpl implements EntityDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityDiscoveryWorkflow workflow;

    @Override
    public EntityDiscoveryResponse discover(String aggregateId) {

        AggregateDetailsResponse aggregate = aggregateQueryService.getAggregate(aggregateId);

        return workflow.execute(buildPrompt(aggregate));

    }

    private String buildPrompt(AggregateDetailsResponse aggregate) {

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n\n");

        builder.append("Name: ").append(aggregate.getName()).append("\n");

        builder.append("Description: ").append(aggregate.getDescription()).append("\n");

        return builder.toString();

    }

}