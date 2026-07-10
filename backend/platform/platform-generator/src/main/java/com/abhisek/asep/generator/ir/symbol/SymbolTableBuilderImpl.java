package com.abhisek.asep.generator.ir.symbol;

import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.ir.model.ApiContractIR;
import com.abhisek.asep.generator.ir.model.CommandIR;
import com.abhisek.asep.generator.ir.model.DomainEventIR;
import com.abhisek.asep.generator.ir.model.DomainServiceIR;
import com.abhisek.asep.generator.ir.model.EntityIR;
import com.abhisek.asep.generator.ir.model.FactoryIR;
import com.abhisek.asep.generator.ir.model.PolicyIR;
import com.abhisek.asep.generator.ir.model.QueryIR;
import com.abhisek.asep.generator.ir.model.RepositoryIR;
import com.abhisek.asep.generator.ir.model.SpecificationIR;
import com.abhisek.asep.generator.ir.model.ValueObjectIR;
import com.abhisek.asep.generator.ir.model.DtoIR;
import com.abhisek.asep.generator.ir.model.MapperIR;
import com.abhisek.asep.generator.ir.model.UseCaseIR;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class SymbolTableBuilderImpl implements SymbolTableBuilder {

    @Override
    public SymbolTable build(AggregateIR aggregate) {

        SymbolTable table = new SymbolTable();

        registerAggregate(table, aggregate);

        aggregate.getEntities().forEach(entity -> register(table, entity, SymbolKind.ENTITY));

        aggregate.getValueObjects().forEach(valueObject -> register(table, valueObject, SymbolKind.VALUE_OBJECT));

        aggregate.getRepositories().forEach(repository -> register(table, repository, SymbolKind.REPOSITORY));

        aggregate.getDomainServices().forEach(service -> register(table, service, SymbolKind.DOMAIN_SERVICE));

        aggregate.getDomainEvents().forEach(event -> register(table, event, SymbolKind.DOMAIN_EVENT));

        aggregate.getApiContracts().forEach(api -> register(table, api, SymbolKind.API_CONTRACT));

        aggregate.getCommands().forEach(command -> register(table, command, SymbolKind.COMMAND));

        aggregate.getQueries().forEach(query -> register(table, query, SymbolKind.QUERY));

        aggregate.getFactories().forEach(factory -> register(table, factory, SymbolKind.FACTORY));

        aggregate.getSpecifications().forEach(spec -> register(table, spec, SymbolKind.SPECIFICATION));

        aggregate.getPolicies().forEach(policy -> register(table, policy, SymbolKind.POLICY));

        aggregate.getDtos().forEach(dto -> register(table, dto, SymbolKind.DTO));

        aggregate.getMappers().forEach(mapper -> register(table, mapper, SymbolKind.MAPPER));

        aggregate.getUseCases().forEach(useCase -> register(table, useCase, SymbolKind.USE_CASE));

        return table;
    }

    private void registerAggregate(SymbolTable table, AggregateIR aggregate) {

        table.register(Symbol.builder().name(aggregate.getName()).kind(SymbolKind.AGGREGATE).node(aggregate).build());

    }

    private void register(SymbolTable table, EntityIR entity, SymbolKind kind) {

        table.register(Symbol.builder().name(entity.getName()).kind(kind).node(entity).build());

    }

    private void register(SymbolTable table, ValueObjectIR valueObject, SymbolKind kind) {

        table.register(Symbol.builder().name(valueObject.getName()).kind(kind).node(valueObject).build());

    }

    private void register(SymbolTable table, RepositoryIR repository, SymbolKind kind) {

        table.register(Symbol.builder().name(repository.getName()).kind(kind).node(repository).build());

    }

    private void register(SymbolTable table, DomainServiceIR service, SymbolKind kind) {

        table.register(Symbol.builder().name(service.getName()).kind(kind).node(service).build());

    }

    private void register(SymbolTable table, DomainEventIR event, SymbolKind kind) {

        table.register(Symbol.builder().name(event.getName()).kind(kind).node(event).build());

    }

    private void register(SymbolTable table, ApiContractIR api, SymbolKind kind) {

        table.register(Symbol.builder().name(api.getName()).kind(kind).node(api).build());

    }

    private void register(SymbolTable table, CommandIR command, SymbolKind kind) {

        table.register(Symbol.builder().name(command.getName()).kind(kind).node(command).build());

    }

    private void register(SymbolTable table, QueryIR query, SymbolKind kind) {

        table.register(Symbol.builder().name(query.getName()).kind(kind).node(query).build());

    }

    private void register(SymbolTable table, FactoryIR factory, SymbolKind kind) {

        table.register(Symbol.builder().name(factory.getName()).kind(kind).node(factory).build());

    }

    private void register(SymbolTable table, SpecificationIR specification, SymbolKind kind) {

        table.register(Symbol.builder().name(specification.getName()).kind(kind).node(specification).build());

    }

    private void register(SymbolTable table, PolicyIR policy, SymbolKind kind) {

        table.register(Symbol.builder().name(policy.getName()).kind(kind).node(policy).build());

    }

    private void register(SymbolTable table, MapperIR mapper, SymbolKind kind) {

        table.register(Symbol.builder().name(mapper.getName()).kind(kind).node(mapper).build());

    }

    private void register(SymbolTable table, UseCaseIR useCase, SymbolKind kind) {

        table.register(Symbol.builder().name(useCase.getName()).kind(kind).node(useCase).build());

    }

    private void register(SymbolTable table, DtoIR dto, SymbolKind kind) {

        table.register(Symbol.builder().name(dto.getName()).kind(kind).node(dto).build());

    }


}