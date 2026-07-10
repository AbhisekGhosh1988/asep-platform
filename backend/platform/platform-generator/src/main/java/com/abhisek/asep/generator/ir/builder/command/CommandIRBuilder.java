package com.abhisek.asep.generator.ir.builder.command;

import com.abhisek.asep.generator.ir.model.CommandIR;
import com.abhisek.asep.generator.model.CommandModel;

public interface CommandIRBuilder {

    CommandIR build(CommandModel source);

}