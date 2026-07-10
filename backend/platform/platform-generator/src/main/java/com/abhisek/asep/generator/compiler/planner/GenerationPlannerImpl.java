package com.abhisek.asep.generator.compiler.planner;

import com.abhisek.asep.generator.backend.spi.ArtifactType;
import com.abhisek.asep.generator.compiler.dependency.DependencyGraph;
import com.abhisek.asep.generator.ir.model.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class GenerationPlannerImpl implements GenerationPlanner {

    @Override
    public GenerationPlan createPlan(DependencyGraph dependencyGraph) {

        GenerationPlan plan = new GenerationPlan();

        int order = 1;

        for (BaseIRNode node : dependencyGraph.getNodes()) {

            ArtifactType artifactType = resolveArtifactType(node);

            if (artifactType == null) {
                continue;
            }

            plan.addTask(GenerationTask.builder().name(node.getName()).
                    artifactType(artifactType).node(node).order(order++).build());

        }

        return plan;

    }

    private ArtifactType resolveArtifactType(BaseIRNode node) {

        if (node instanceof EntityIR) {
            return ArtifactType.ENTITY;
        }

        if (node instanceof ValueObjectIR) {
            return ArtifactType.VALUE_OBJECT;
        }

        if (node instanceof RepositoryIR) {
            return ArtifactType.REPOSITORY;
        }

        if (node instanceof DomainServiceIR) {
            return ArtifactType.SERVICE;
        }

        if (node instanceof DomainEventIR) {
            return ArtifactType.DOMAIN_EVENT;
        }

        if (node instanceof CommandIR) {
            return ArtifactType.COMMAND;
        }

        if (node instanceof QueryIR) {
            return ArtifactType.QUERY;
        }

        if (node instanceof FactoryIR) {
            return ArtifactType.FACTORY;
        }

        if (node instanceof SpecificationIR) {
            return ArtifactType.SPECIFICATION;
        }

        if (node instanceof PolicyIR) {
            return ArtifactType.POLICY;
        }

        if (node instanceof DtoIR) {
            return ArtifactType.DTO;
        }

        if (node instanceof MapperIR) {
            return ArtifactType.MAPPER;
        }

        if (node instanceof UseCaseIR) {
            return ArtifactType.USE_CASE;
        }
        if (node instanceof ApiContractIR) {
            return ArtifactType.CONTROLLER;
        }
        return null;

    }

}