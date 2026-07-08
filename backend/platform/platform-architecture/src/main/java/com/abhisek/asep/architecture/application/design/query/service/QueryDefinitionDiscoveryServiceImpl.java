package com.abhisek.asep.architecture.application.design.query.service;

import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.application.design.apicontract.query.service.ApiContractQueryService;
import com.abhisek.asep.architecture.application.design.attribute.query.dto.AttributeDetailsResponse;
import com.abhisek.asep.architecture.application.design.attribute.query.service.AttributeQueryService;
import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.service.DomainServiceDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.entity.query.dto.EntityDetailsResponse;
import com.abhisek.asep.architecture.application.design.entity.query.service.EntityQueryService;
import com.abhisek.asep.architecture.application.design.query.ai.dto.QueryDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.query.ai.workflow.QueryDefinitionDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QueryDefinitionDiscoveryServiceImpl implements QueryDefinitionDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final EntityQueryService entityQueryService;

    private final AttributeQueryService attributeQueryService;

    private final DomainServiceDefinitionQueryService domainServiceQueryService;

    private final ApiContractQueryService apiContractQueryService;

    private final QueryDefinitionDiscoveryWorkflow workflow;

    @Override
    public QueryDefinitionDiscoveryResponse discover(String aggregateId) {

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

        builder.append("API Contracts\n");

        for (ApiContractDetailsResponse api : apiContractQueryService.getApiContracts(aggregateId)) {

            builder.append("- ").append(api.getMethod()).append(" ").append(api.getPath()).append(" (").append(api.getName()).append(")").append("\n");

        }

        builder.append("\n");

        builder.append("Entities\n");

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