package com.abhisek.asep.architecture.application.design.command.service;


import com.abhisek.asep.architecture.application.design.apicontract.query.dto.ApiContractDetailsResponse;
import com.abhisek.asep.architecture.application.design.apicontract.query.service.ApiContractQueryService;
import com.abhisek.asep.architecture.application.design.command.ai.dto.CommandDefinitionDiscoveryResponse;
import com.abhisek.asep.architecture.application.design.command.ai.workflow.CommandDefinitionDiscoveryWorkflow;
import com.abhisek.asep.architecture.application.design.domainservice.query.dto.DomainServiceDefinitionDetailsResponse;
import com.abhisek.asep.architecture.application.design.domainservice.query.service.DomainServiceDefinitionQueryService;
import com.abhisek.asep.architecture.application.design.query.dto.AggregateDetailsResponse;
import com.abhisek.asep.architecture.application.design.query.service.AggregateQueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommandDefinitionDiscoveryServiceImpl implements CommandDefinitionDiscoveryService {

    private final AggregateQueryService aggregateQueryService;

    private final DomainServiceDefinitionQueryService domainServiceQueryService;

    private final ApiContractQueryService apiContractQueryService;

    private final CommandDefinitionDiscoveryWorkflow workflow;

    @Override
    public CommandDefinitionDiscoveryResponse discover(String aggregateId) {

        AggregateDetailsResponse aggregate = aggregateQueryService.getAggregate(aggregateId);

        StringBuilder builder = new StringBuilder();

        builder.append("Aggregate\n");
        builder.append("Name : ").append(aggregate.getName()).append("\n");

        builder.append("Description : ").append(aggregate.getDescription()).append("\n\n");

        builder.append("Domain Services\n");

        for (DomainServiceDefinitionDetailsResponse service : domainServiceQueryService.getDomainServices(aggregateId)) {

            builder.append("- ").append(service.getName()).append("\n");

        }

        builder.append("\nAPI Contracts\n");

        for (ApiContractDetailsResponse api : apiContractQueryService.getApiContracts(aggregateId)) {

            builder.append("- ").append(api.getMethod()).append(" ").append(api.getPath()).append(" (").append(api.getName()).append(")\n");

        }

        return workflow.execute(builder.toString());

    }

}