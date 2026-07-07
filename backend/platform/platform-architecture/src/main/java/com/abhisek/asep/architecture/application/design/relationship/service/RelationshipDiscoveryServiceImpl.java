package com.abhisek.asep.architecture.application.design.relationship.service;

import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import com.abhisek.asep.architecture.application.design.relationship.ai.dto.RelationshipDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.relationship.ai.workflow.RelationshipDiscoveryWorkflow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RelationshipDiscoveryServiceImpl implements RelationshipDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityQueryService entityQueryService;

    private final AttributeQueryService attributeQueryService;

    private final RelationshipDiscoveryWorkflow workflow;

    @Override
    public RelationshipDiscoveryResponse discover(String aggregateId) {

        AggregateDetailsResponse aggregate = aggregateQueryService.getAggregate(aggregateId);

        List<EntityDetailsResponse> entities = entityQueryService.getEntities(aggregateId);

        String aggregateModel = buildAggregateModel(aggregate, entities);

        return workflow.execute(aggregateModel);

    }

    private String buildAggregateModel(AggregateDetailsResponse aggregate, List<EntityDetailsResponse> entities) {

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n\n");

        builder.append("Name: ").append(aggregate.getName()).append("\n");

        builder.append("Description: ").append(aggregate.getDescription()).append("\n\n");

        for (EntityDetailsResponse entity : entities) {

            builder.append("---------------------------------\n");

            builder.append("Entity\n");

            builder.append("Name: ").append(entity.getName()).append("\n");

            builder.append("Description: ").append(entity.getDescription()).append("\n");

            List<AttributeDetailsResponse> attributes = attributeQueryService.getAttributes(entity.getId());

            builder.append("Attributes\n");

            for (AttributeDetailsResponse attribute : attributes) {

                builder.append(" - ").append(attribute.getName()).append(" : ").append(attribute.getDataType()).append("\n");

            }

            builder.append("\n");

        }

        return builder.toString();

    }

}