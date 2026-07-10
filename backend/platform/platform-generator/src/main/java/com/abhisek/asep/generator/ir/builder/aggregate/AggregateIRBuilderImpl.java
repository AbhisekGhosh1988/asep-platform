package com.abhisek.asep.generator.ir.builder.aggregate;


import com.abhisek.asep.generator.compiler.context.CompilerContext;
import com.abhisek.asep.generator.ir.builder.apicontract.ApiContractIRBuilder;
import com.abhisek.asep.generator.ir.builder.command.CommandIRBuilder;
import com.abhisek.asep.generator.ir.builder.domainevent.DomainEventIRBuilder;
import com.abhisek.asep.generator.ir.builder.domainservice.DomainServiceIRBuilder;
import com.abhisek.asep.generator.ir.builder.dto.DtoIRBuilder;
import com.abhisek.asep.generator.ir.builder.entity.EntityIRBuilder;
import com.abhisek.asep.generator.ir.builder.factory.FactoryIRBuilder;
import com.abhisek.asep.generator.ir.builder.mapper.MapperIRBuilder;
import com.abhisek.asep.generator.ir.builder.policy.PolicyIRBuilder;
import com.abhisek.asep.generator.ir.builder.query.QueryIRBuilder;
import com.abhisek.asep.generator.ir.builder.repository.RepositoryIRBuilder;
import com.abhisek.asep.generator.ir.builder.specification.SpecificationIRBuilder;
import com.abhisek.asep.generator.ir.builder.usecase.UseCaseIRBuilder;
import com.abhisek.asep.generator.ir.builder.valueobject.ValueObjectIRBuilder;
import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.model.AggregateModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AggregateIRBuilderImpl implements AggregateIRBuilder {


    private final EntityIRBuilder entityIRBuilder;
    private final ValueObjectIRBuilder valueObjectIRBuilder;
    private final RepositoryIRBuilder repositoryIRBuilder;
    private final DomainServiceIRBuilder domainServiceIRBuilder;
    private final DomainEventIRBuilder domainEventIRBuilder;
    private final ApiContractIRBuilder apiContractIRBuilder;
    private final CommandIRBuilder commandIRBuilder;
    private final QueryIRBuilder queryIRBuilder;
    private final FactoryIRBuilder factoryIRBuilder;
    private final SpecificationIRBuilder specificationIRBuilder;
    private final PolicyIRBuilder policyIRBuilder;
    private final UseCaseIRBuilder useCaseIRBuilder;
    private final DtoIRBuilder dtoIRBuilder;
    private final MapperIRBuilder mapperIRBuilder;

    @Override
    public AggregateIR build(AggregateModel source) {

        AggregateIR aggregateIR = new AggregateIR();

        aggregateIR.setName(source.getName());
        aggregateIR.setDescription(source.getDescription());

        aggregateIR.setEntities(source.getEntities().stream().map(entityIRBuilder::build).toList());

        aggregateIR.setValueObjects(source.getValueObjects().stream().map(valueObjectIRBuilder::build).toList());

        aggregateIR.setRepositories(source.getRepositories().stream().map(repositoryIRBuilder::build).toList());

        aggregateIR.setDomainServices(source.getDomainServices().stream().map(domainServiceIRBuilder::build).toList());

        aggregateIR.setDomainEvents(source.getDomainEvents().stream().map(domainEventIRBuilder::build).toList());

        aggregateIR.setApiContracts(source.getApiContracts().stream().map(apiContractIRBuilder::build).toList());

        aggregateIR.setCommands(source.getCommands().stream().map(commandIRBuilder::build).toList());

        aggregateIR.setQueries(source.getQueries().stream().map(queryIRBuilder::build).toList());

        aggregateIR.setFactories(source.getFactories().stream().map(factoryIRBuilder::build).toList());

        aggregateIR.setSpecifications(source.getSpecifications().stream().map(specificationIRBuilder::build).toList());

        aggregateIR.setPolicies(source.getPolicies().stream().map(policyIRBuilder::build).toList());

        aggregateIR.setUseCases(source.getUseCases().stream().map(useCaseIRBuilder::build).toList());

        aggregateIR.setDtos(source.getDtoModels().stream().map(dtoIRBuilder::build).toList());

        aggregateIR.setMappers(source.getMapperModels().stream().map(mapperIRBuilder::build).toList());

        return aggregateIR;
    }
}