package com.abhisek.asep.generator.ir.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateIR
        extends BaseIRNode {

    /**
     * Entities.
     */
    @Builder.Default
    private List<EntityIR> entities =
            new ArrayList<>();

    /**
     * Value Objects.
     */
    @Builder.Default
    private List<ValueObjectIR> valueObjects =
            new ArrayList<>();

    /**
     * Repositories.
     */
    @Builder.Default
    private List<RepositoryIR> repositories =
            new ArrayList<>();

    /**
     * Domain Services.
     */
    @Builder.Default
    private List<DomainServiceIR> domainServices =
            new ArrayList<>();

    /**
     * Domain Events.
     */
    @Builder.Default
    private List<DomainEventIR> domainEvents =
            new ArrayList<>();

    /**
     * API Contracts.
     */
    @Builder.Default
    private List<ApiContractIR> apiContracts =
            new ArrayList<>();

    /**
     * Commands.
     */
    @Builder.Default
    private List<CommandIR> commands =
            new ArrayList<>();

    /**
     * Queries.
     */
    @Builder.Default
    private List<QueryIR> queries =
            new ArrayList<>();

    /**
     * Factories.
     */
    @Builder.Default
    private List<FactoryIR> factories =
            new ArrayList<>();

    /**
     * Specifications.
     */
    @Builder.Default
    private List<SpecificationIR> specifications =
            new ArrayList<>();

    /**
     * Policies.
     */
    @Builder.Default
    private List<PolicyIR> policies =
            new ArrayList<>();

}