package com.abhisek.asep.generator.ir.builder.entity;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.builder.attribute.AttributeIRBuilder;
import com.abhisek.asep.generator.ir.builder.relationship.RelationshipIRBuilder;
import com.abhisek.asep.generator.ir.model.AttributeIR;
import com.abhisek.asep.generator.ir.model.EntityIR;
import com.abhisek.asep.generator.ir.model.RelationshipIR;
import com.abhisek.asep.generator.model.AttributeModel;
import com.abhisek.asep.generator.model.EntityModel;
import com.abhisek.asep.generator.model.RelationshipModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class DefaultEntityIRBuilder
        extends BaseArtifactIRBuilder<EntityModel, EntityIR>
        implements EntityIRBuilder {

    private final AttributeIRBuilder attributeIRBuilder;

    private final RelationshipIRBuilder relationshipIRBuilder;

    @Override
    protected void validate(EntityModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Entity name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {
        return "Entity";
    }

    @Override
    protected EntityIR doBuild(EntityModel source) {

        List<AttributeIR> attributes =
                source.getAttributes()
                        .stream()
                        .map(attributeIRBuilder::build)
                        .collect(Collectors.toList());

        List<RelationshipIR> relationships =
                source.getRelationships()
                        .stream()
                        .map(relationshipIRBuilder::build)
                        .collect(Collectors.toList());

        return EntityIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .attributes(attributes)
                .relationships(relationships)
                .build();

    }

}