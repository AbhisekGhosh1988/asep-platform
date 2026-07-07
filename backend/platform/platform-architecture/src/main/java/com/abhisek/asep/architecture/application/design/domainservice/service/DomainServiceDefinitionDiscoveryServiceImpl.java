package com.abhisek.asep.architecture.application.design.domainservice.service;


import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import com.abhisek.asep.architecture.application.design.relationship.query.dto.RelationshipDetailsResponse;
import com.abhisek.asep.architecture.application.design.relationship.query.service.RelationshipQueryService;
import com.abhisek.asep.architecture.application.design.repository.query.dto.RepositoryDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.repository.query.service.RepositoryDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.valueobject.query.dto.ValueObjectDetailsResponse;
import com.abhisek.asep.architecture.application.design.valueobject.query.service.ValueObjectQueryService;
import com.abhisek.asep.architecture.application.design.domainservice.ai.dto.DomainServiceDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.domainservice.ai.workflow.DomainServiceDefinitionDiscoveryWorkflow;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DomainServiceDefinitionDiscoveryServiceImpl implements DomainServiceDefinitionDiscoveryService {

    private final AggregateQueryService aggregateQueryService;
    private final EntityQueryService entityQueryService;
    private final AttributeQueryService attributeQueryService;
    private final RelationshipQueryService relationshipQueryService;
    private final ValueObjectQueryService valueObjectQueryService;
    private final RepositoryDefinitionQueryService repositoryDefinitionQueryService;
    private final DomainServiceDefinitionDiscoveryWorkflow workflow;

    @Override
    public DomainServiceDefinitionDiscoveryResponse discover(String aggregateId) {

        AggregateDetailsResponse aggregate = aggregateQueryService.getAggregate(aggregateId);

        List<EntityDetailsResponse> entities = entityQueryService.getEntities(aggregateId);

        return workflow.execute(buildAggregateModel(aggregate, entities, aggregateId));

    }

    private String buildAggregateModel(AggregateDetailsResponse aggregate, List<EntityDetailsResponse> entities, String aggregateId) {

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n");
        builder.append("Name : ").append(aggregate.getName()).append("\n");
        builder.append("Description : ").append(aggregate.getDescription()).append("\n\n");

        builder.append("Repositories\n");

        for (RepositoryDefinitionDetailsResponse repository : repositoryDefinitionQueryService.getRepositoryDefinitions(aggregateId)) {

            builder.append("- ").append(repository.getName()).append("\n");

        }

        builder.append("\nValue Objects\n");

        for (ValueObjectDetailsResponse valueObject : valueObjectQueryService.getValueObjects(aggregateId)) {

            builder.append("- ").append(valueObject.getName()).append("\n");

        }

        builder.append("\n");

        for (EntityDetailsResponse entity : entities) {

            builder.append("--------------------------------\n");

            builder.append("Entity : ").append(entity.getName()).append("\n");

            builder.append("Description : ").append(entity.getDescription()).append("\n");

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