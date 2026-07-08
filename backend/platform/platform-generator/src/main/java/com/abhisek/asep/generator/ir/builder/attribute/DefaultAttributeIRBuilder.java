package com.abhisek.asep.generator.ir.builder.attribute;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.model.AttributeIR;
import com.abhisek.asep.generator.model.AttributeModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultAttributeIRBuilder
        extends AbstractIRBuilder<AttributeModel, AttributeIR>
        implements AttributeIRBuilder {

    @Override
    protected void validate(AttributeModel source) {

        super.validate(source);

        if (source.getName() == null || source.getName().isBlank()) {
            throw new IllegalArgumentException(
                    "Attribute name cannot be null or blank.");
        }

        if (source.getDataType() == null || source.getDataType().isBlank()) {
            throw new IllegalArgumentException(
                    "Attribute data type cannot be null or blank.");
        }

    }

    @Override
    protected AttributeIR doBuild(AttributeModel source) {

        return AttributeIR.builder()
                .id(source.getId())
                .name(source.getName())
                .dataType(source.getDataType())
                .identifier(source.isIdentifier())
                .nullable(source.isNullable())

                // Generator defaults
                .unique(false)
                .collection(false)
                .defaultValue(null)

                .build();

    }

}