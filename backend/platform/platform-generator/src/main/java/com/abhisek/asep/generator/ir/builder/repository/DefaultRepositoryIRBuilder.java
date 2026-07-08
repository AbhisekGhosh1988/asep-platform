package com.abhisek.asep.generator.ir.builder.repository;

import com.abhisek.asep.generator.ir.builder.AbstractIRBuilder;
import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.RepositoryIR;
import com.abhisek.asep.generator.model.RepositoryModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultRepositoryIRBuilder
        extends BaseArtifactIRBuilder<RepositoryModel, RepositoryIR>
        implements RepositoryIRBuilder {

    @Override
    protected void validate(RepositoryModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Repository name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {
        return "Repository";
    }

    @Override
    protected RepositoryIR doBuild(RepositoryModel source) {

        return RepositoryIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())

                // Populated during Aggregate compilation
                .interfaceName(null)
                .entityName(null)
                .idType(null)

                .build();

    }

}