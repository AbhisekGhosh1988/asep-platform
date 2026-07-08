package com.abhisek.asep.generator.ir.builder.apicontract;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.ApiContractIR;
import com.abhisek.asep.generator.model.ApiContractModel;
import org.springframework.stereotype.Component;

@Component
public class ApiContractIRBuilderImpl
        extends BaseArtifactIRBuilder<ApiContractModel, ApiContractIR>
        implements ApiContractIRBuilder {

    @Override
    protected String getArtifactType() {

        return "API Contract";

    }

    @Override
    protected void validate(ApiContractModel source) {

        super.validate(source);

        if (source.getMethod() == null ||
                source.getMethod().isBlank()) {

            throw new IllegalArgumentException(
                    "HTTP method cannot be null or blank.");

        }

        if (source.getPath() == null ||
                source.getPath().isBlank()) {

            throw new IllegalArgumentException(
                    "API path cannot be null or blank.");

        }

    }

    @Override
    protected ApiContractIR doBuild(ApiContractModel source) {

        return ApiContractIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .httpMethod(source.getMethod())
                .path(source.getPath())

                // Populated during DTO generation
                .requestType(null)
                .responseType(null)

                .build();

    }

}