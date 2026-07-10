package com.abhisek.asep.generator.ir.builder.domainevent;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.builder.attribute.AttributeIRBuilder;
import com.abhisek.asep.generator.ir.model.DomainEventIR;
import com.abhisek.asep.generator.model.DomainEventModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultDomainEventIRBuilder extends BaseArtifactIRBuilder<DomainEventModel, DomainEventIR> implements DomainEventIRBuilder {

    private final AttributeIRBuilder attributeIRBuilder;

    @Override
    protected void validate(DomainEventModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {

            throw new IllegalArgumentException("Domain Event name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "DomainEvent";

    }

    @Override
    protected DomainEventIR doBuild(DomainEventModel source) {

        DomainEventIR event = DomainEventIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).build();

        source.getAttributes().forEach(attribute -> event.getAttributes().add(attributeIRBuilder.build(attribute)));

        return event;

    }

}