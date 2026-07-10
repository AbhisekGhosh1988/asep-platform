package com.abhisek.asep.generator.ir.builder.query;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.QueryIR;
import com.abhisek.asep.generator.model.QueryModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultQueryIRBuilder
        extends BaseArtifactIRBuilder<QueryModel, QueryIR>
        implements QueryIRBuilder {

    @Override
    protected void validate(QueryModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Query name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Query";

    }

    @Override
    protected QueryIR doBuild(QueryModel source) {

        return QueryIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .handler(source.getHandler())
                .responseType(source.getResponseType())
                .build();

    }

}