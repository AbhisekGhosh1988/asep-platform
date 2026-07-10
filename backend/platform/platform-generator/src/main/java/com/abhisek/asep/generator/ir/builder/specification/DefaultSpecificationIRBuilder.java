package com.abhisek.asep.generator.ir.builder.specification;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.SpecificationIR;
import com.abhisek.asep.generator.model.SpecificationModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultSpecificationIRBuilder
        extends BaseArtifactIRBuilder<SpecificationModel, SpecificationIR>
        implements SpecificationIRBuilder {

    @Override
    protected void validate(SpecificationModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Specification name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Specification";

    }

    @Override
    protected SpecificationIR doBuild(
            SpecificationModel source) {

        return SpecificationIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .targetEntity(source.getTargetEntity())
                .build();

    }

}