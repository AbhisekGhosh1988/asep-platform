package com.abhisek.asep.generator.ir.builder.domainevent;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.DomainEventIR;
import com.abhisek.asep.generator.model.DomainEventModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class DomainEventIRBuilderImpl
        extends BaseArtifactIRBuilder<DomainEventModel, DomainEventIR>
        implements DomainEventIRBuilder {

    @Override
    protected String getArtifactType() {
        return "Domain Event";
    }

    @Override
    protected DomainEventIR doBuild(
            DomainEventModel source) {

        return DomainEventIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())

                // Populated during a later compiler phase
                .attributes(new ArrayList<>())

                .build();

    }

}