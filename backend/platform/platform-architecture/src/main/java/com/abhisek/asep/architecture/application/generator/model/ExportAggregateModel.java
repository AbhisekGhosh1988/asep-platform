package com.abhisek.asep.architecture.application.generator.model;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ExportAggregateModel {

    private String id;

    private String name;

    private String description;

    @Builder.Default
    private List<ExportEntityModel> entities =
            new ArrayList<>();

    @Builder.Default
    private List<ExportValueObjectModel> valueObjects =
            new ArrayList<>();

    @Builder.Default
    private List<ExportRepositoryModel> repositories =
            new ArrayList<>();

    @Builder.Default
    private List<ExportDomainServiceModel> domainServices =
            new ArrayList<>();

    @Builder.Default
    private List<ExportDomainEventModel> events =
            new ArrayList<>();

    @Builder.Default
    private List<ExportApiContractModel> apiContracts =
            new ArrayList<>();

    @Builder.Default
    private List<ExportCommandModel> commands =
            new ArrayList<>();

    @Builder.Default
    private List<ExportQueryModel> queries =
            new ArrayList<>();

    @Builder.Default
    private List<ExportFactoryModel> factories =
            new ArrayList<>();

    @Builder.Default
    private List<ExportSpecificationModel> specifications =
            new ArrayList<>();

    @Builder.Default
    private List<ExportPolicyModel> policies =
            new ArrayList<>();

}