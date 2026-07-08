package com.abhisek.asep.architecture.application.design.apicontract.service;


import com.abhisek.asep.architecture.application.design.apicontract.ai.dto.ApiContractDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.apicontract.ai.workflow.ApiContractDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.service.DomainServiceDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.domainevent.query.dto.DomainEventDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainevent.query.service.DomainEventDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ApiContractDiscoveryServiceImpl implements ApiContractDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityQueryService entityQueryService;

    private final AttributeQueryService attributeQueryService;

    private final DomainServiceDefinitionQueryService domainServiceQueryService;

    private final DomainEventDefinitionQueryService domainEventQueryService;

    private final ApiContractDiscoveryWorkflow workflow;

    @Override
    public ApiContractDiscoveryResponse discover(String aggregateId) {

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

        builder.append("\nDomain Events\n");

        for (DomainEventDefinitionDetailsResponse event : domainEventQueryService.getDomainEvents(aggregateId)) {

            builder.append("- ").append(event.getName()).append("\n");

        }

        builder.append("\nEntities\n");

        for (EntityDetailsResponse entity : entities) {

            builder.append(entity.getName()).append("\n");

            for (AttributeDetailsResponse attribute : attributeQueryService.getAttributes(entity.getId())) {

                builder.append("   - ").append(attribute.getName()).append(" : ").append(attribute.getDataType()).append("\n");

            }

            builder.append("\n");

        }

        return builder.toString();

    }

}