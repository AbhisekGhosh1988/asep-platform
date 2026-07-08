package com.abhisek.asep.generator.model;

import lombok.*;
import lombok.experimental.SuperBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
public class AggregateModel
        extends BaseArtifactModel {

    @Builder.Default
    private List<EntityModel> entities =
            new ArrayList<>();

    @Builder.Default
    private List<ValueObjectModel> valueObjects =
            new ArrayList<>();

    @Builder.Default
    private List<RepositoryModel> repositories =
            new ArrayList<>();

    @Builder.Default
    private List<DomainServiceModel> domainServices =
            new ArrayList<>();

    @Builder.Default
    private List<DomainEventModel> domainEvents =
            new ArrayList<>();

    @Builder.Default
    private List<ApiContractModel> apiContracts =
            new ArrayList<>();

    @Builder.Default
    private List<CommandModel> commands =
            new ArrayList<>();

    @Builder.Default
    private List<QueryModel> queries =
            new ArrayList<>();

    @Builder.Default
    private List<FactoryModel> factories =
            new ArrayList<>();

    @Builder.Default
    private List<SpecificationModel> specifications =
            new ArrayList<>();

    @Builder.Default
    private List<PolicyModel> policies =
            new ArrayList<>();

}