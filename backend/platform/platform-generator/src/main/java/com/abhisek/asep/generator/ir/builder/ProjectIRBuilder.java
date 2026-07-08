package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.ProjectIR;

public interface ProjectIRBuilder {

    ProjectIR build(
            String projectId);

}