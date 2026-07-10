package com.abhisek.asep.generator.ir.builder.factory;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.builder.domainservice.ServiceOperationIRBuilder;
import com.abhisek.asep.generator.ir.model.FactoryIR;
import com.abhisek.asep.generator.model.FactoryModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultFactoryIRBuilder extends BaseArtifactIRBuilder<FactoryModel, FactoryIR> implements FactoryIRBuilder {

    private final ServiceOperationIRBuilder serviceOperationIRBuilder;

    @Override
    protected void validate(FactoryModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {

            throw new IllegalArgumentException("Factory name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Factory";

    }

    @Override
    protected FactoryIR doBuild(FactoryModel source) {

        FactoryIR factory = FactoryIR.builder().id(source.getId()).name(source.getName()).description(source.getDescription()).build();

        source.getMethods().forEach(method -> factory.getMethods().add(serviceOperationIRBuilder.build(method)));

        return factory;

    }

}