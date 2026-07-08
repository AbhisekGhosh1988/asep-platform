package com.abhisek.asep.generator.ir.builder.relationship;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.model.RelationshipIR;
import com.abhisek.asep.generator.model.RelationshipModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultRelationshipIRBuilder
        extends AbstractIRBuilder<RelationshipModel, RelationshipIR>
        implements RelationshipIRBuilder {

    @Override
    protected void validate(RelationshipModel source) {

        super.validate(source);

        if (source.getSourceEntity() == null ||
                source.getSourceEntity().isBlank()) {

            throw new IllegalArgumentException(
                    "Relationship source entity cannot be null or blank.");

        }

        if (source.getTargetEntity() == null ||
                source.getTargetEntity().isBlank()) {

            throw new IllegalArgumentException(
                    "Relationship target entity cannot be null or blank.");

        }

        if (source.getRelationshipType() == null ||
                source.getRelationshipType().isBlank()) {

            throw new IllegalArgumentException(
                    "Relationship type cannot be null or blank.");

        }

    }

    @Override
    protected RelationshipIR doBuild(RelationshipModel source) {

        return RelationshipIR.builder()
                .id(source.getId())
                .name(source.getSourceEntity() + "->" + source.getTargetEntity())
                .description(null)
                .sourceEntity(source.getSourceEntity())
                .targetEntity(source.getTargetEntity())
                .relationshipType(source.getRelationshipType())

                // Will be determined by semantic analysis later
                .owningSide(false)

                .build();

    }

}