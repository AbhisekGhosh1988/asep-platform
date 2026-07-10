package com.abhisek.asep.generator.ir.builder.command;

import com.abhisek.asep.generator.ir.builder.BaseArtifactIRBuilder;
import com.abhisek.asep.generator.ir.model.CommandIR;
import com.abhisek.asep.generator.model.CommandModel;
import org.springframework.stereotype.Component;

@Component
public class DefaultCommandIRBuilder
        extends BaseArtifactIRBuilder<CommandModel, CommandIR>
        implements CommandIRBuilder {

    @Override
    protected void validate(CommandModel source) {

        super.validate(source);

        if (source.getName() == null ||
                source.getName().isBlank()) {

            throw new IllegalArgumentException(
                    "Command name cannot be null or blank.");

        }

    }

    @Override
    protected String getArtifactType() {

        return "Command";

    }

    @Override
    protected CommandIR doBuild(CommandModel source) {

        return CommandIR.builder()
                .id(source.getId())
                .name(source.getName())
                .description(source.getDescription())
                .handler(source.getHandler())
                .requestType(source.getRequestType())
                .responseType(source.getResponseType())
                .build();

    }

}