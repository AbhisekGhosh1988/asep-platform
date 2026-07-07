package com.abhisek.asep.architecture.application.design.domainevent.service;


import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.service.DomainServiceDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.domainevent.ai.dto.DomainEventDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainevent.ai.workflow.DomainEventDefinitionDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.application.design.relationship.query.service.RelationshipQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainEventDefinitionDiscoveryServiceImpl implements DomainEventDefinitionDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityQueryService entityQueryService;

    private final AttributeQueryService attributeQueryService;

    private final RelationshipQueryService relationshipQueryService;

    private final DomainServiceDefinitionQueryService domainServiceQueryService;

    private final DomainEventDefinitionDiscoveryWorkflow workflow;

    @Override
    public DomainEventDefinitionDiscoveryResponse discover(String aggregateId) {

        AggregateDetailsResponse aggregate = aggregateQueryService.getAggregate(aggregateId);

        List<EntityDetailsResponse> entities = entityQueryService.getEntities(aggregateId);

        return workflow.execute(buildAggregateModel(aggregate, entities, aggregateId));

    }

    private String buildAggregateModel(AggregateDetailsResponse aggregate, List<EntityDetailsResponse> entities, String aggregateId) {

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n");
        builder.append("Name : ").append(aggregate.getName()).append("\n");

        builder.append("Description : ").append(aggregate.getDescription()).append("\n\n");

        builder.append("Domain Services\n");

        for (DomainServiceDefinitionDetailsResponse service : domainServiceQueryService.getDomainServices(aggregateId)) {

            builder.append("- ").append(service.getName()).append("\n");

        }

        builder.append("\n");

        for (EntityDetailsResponse entity : entities) {

            builder.append("Entity : ").append(entity.getName()).append("\n");

            builder.append("Attributes\n");

            for (AttributeDetailsResponse attribute : attributeQueryService.getAttributes(entity.getId())) {

                builder.append("- ").append(attribute.getName()).append(" : ").append(attribute.getDataType()).append("\n");

            }

            builder.append("Relationships\n");

            for (RelationshipDetailsResponse relationship : relationshipQueryService.getRelationships(entity.getId())) {

                builder.append("- ").append(relationship.getRelationshipType()).append(" -> ").append(relationship.getTargetEntityId()).append("\n");

            }

            builder.append("\n");

        }

        return builder.toString();

    }

}