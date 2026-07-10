package com.abhisek.asep.generator.ir.builder.domainservice;

import com.abhisek.asep.generator.ir.model.ParameterIR;
import com.abhisek.asep.generator.ir.model.ServiceOperationIR;
import com.abhisek.asep.generator.model.ParameterModel;
import com.abhisek.asep.generator.model.ServiceOperationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DefaultServiceOperationIRBuilder
        implements ServiceOperationIRBuilder {

    @Override
    public ServiceOperationIR build(ServiceOperationModel source) {

        ServiceOperationIR operation =
                ServiceOperationIR.builder()
                        .id(source.getId())
                        .name(source.getName())
                        .description(source.getDescription())
                        .returnType(source.getReturnType())
                        .build();

        for (ParameterModel parameter : source.getParameters()) {

            operation.getParameters().add(
                    ParameterIR.builder()
                            .name(parameter.getName())
                            .type(parameter.getType())
                            .build());

        }

        return operation;

    }

}