package com.abhisek.asep.generator.ir.builder.valueobject;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.ValueObjectIR;
import com.abhisek.asep.generator.model.ValueObjectModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultValueObjectIRBuilder
        extends BaseArtifactIRBuilder<ValueObjectModel, ValueObjectIR>
        implements ValueObjectIRBuilder {

    @Override
    protected void validate(
            ValueObjectModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Value Object name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {
        return "ValueObject";
    }

    @Override
    protected ValueObjectIR doBuild(
            ValueObjectModel source) {

        return ValueObjectIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .build();

    }


}