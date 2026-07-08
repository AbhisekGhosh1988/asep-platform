package com.abhisek.asep.generator.ir.builder.domainservice;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.DomainServiceIR;
import com.abhisek.asep.generator.model.DomainServiceModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DefaultDomainServiceIRBuilder
        extends BaseArtifactIRBuilder<DomainServiceModel, DomainServiceIR>
        implements DomainServiceIRBuilder {

    @Override
    protected void validate(DomainServiceModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Domain Service name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {
        return "DomainService";
    }

    @Override
    protected DomainServiceIR doBuild(
            DomainServiceModel source) {

        return DomainServiceIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())

                // Will be populated in a later compiler phase
                .operations(new ArrayList<>())

                .build();

    }

}