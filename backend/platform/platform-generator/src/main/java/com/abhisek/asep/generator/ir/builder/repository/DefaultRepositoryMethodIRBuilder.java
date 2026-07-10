package com.abhisek.asep.generator.ir.builder.repository;

import com.abhisek.asep.generator.ir.model.ParameterIR;
import com.abhisek.asep.generator.ir.model.RepositoryMethodIR;
import com.abhisek.asep.generator.model.ParameterModel;
import com.abhisek.asep.generator.model.RepositoryMethodModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultRepositoryMethodIRBuilder
        implements RepositoryMethodIRBuilder {

    @Override
    public RepositoryMethodIR build(
            RepositoryMethodModel source) {

        RepositoryMethodIR ir = RepositoryMethodIR.builder()
                .name(source.getName())
                .returnType(source.getReturnType())
                .build();

        for (ParameterModel parameter : source.getParameters()) {
            ir.getParameters().add(
                    ParameterIR.builder()
                            .name(parameter.getName())
                            .type(parameter.getType())
                            .build());
        }

        return ir;

    }

}