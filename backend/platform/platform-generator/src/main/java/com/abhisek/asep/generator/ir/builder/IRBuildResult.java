package com.abhisek.asep.generator.ir.builder;

import com.abhisek.asep.generator.ir.model.ProjectIR;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class IRBuildResult {

    private ProjectIR project;

    private IRBuildReport report;

}