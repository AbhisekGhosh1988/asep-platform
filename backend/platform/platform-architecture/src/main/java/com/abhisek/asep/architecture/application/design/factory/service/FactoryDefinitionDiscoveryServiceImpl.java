package com.abhisek.asep.architecture.application.design.factory.service;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.factory.ai.dto.FactoryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.factory.ai.workflow.FactoryDefinitionDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FactoryDefinitionDiscoveryServiceImpl
        implements FactoryDefinitionDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityQueryService entityQueryService;

    private final AttributeQueryService attributeQueryService;

    private final FactoryDefinitionDiscoveryWorkflow workflow;

    @Override
    public FactoryDefinitionDiscoveryResponse discover(
            String aggregateId) {

        AggregateDetailsResponse aggregate =
                aggregateQueryService.getAggregate(aggregateId);

        List<EntityDetailsResponse> entities =
                entityQueryService.getEntities(aggregateId);

        return workflow.execute(
                buildAggregateModel(
                        aggregate,
                        entities));

    }

    private String buildAggregateModel(
            AggregateDetailsResponse aggregate,
            List<EntityDetailsResponse> entities) {

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n");
        builder.append("Name : ")
                .append(aggregate.getName())
                .append("\n");

        builder.append("Description : ")
                .append(aggregate.getDescription())
                .append("\n\n");

        builder.append("Entities\n");

        for (EntityDetailsResponse entity : entities) {

            builder.append(entity.getName())
                    .append("\n");

            for (AttributeDetailsResponse attribute :
                    attributeQueryService.getAttributes(entity.getId())) {

                builder.append("   - ")
                        .append(attribute.getName())
                        .append(" : ")
                        .append(attribute.getDataType())
                        .append("\n");

            }

            builder.append("\n");

        }

        return builder.toString();

    }

}