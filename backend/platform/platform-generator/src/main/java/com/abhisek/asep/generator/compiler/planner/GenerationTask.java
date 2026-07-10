package com.abhisek.asep.generator.compiler.planner;

import com.abhisek.asep.generator.backend.spi.ArtifactType;
import com.abhisek.asep.generator.ir.model.BaseIRNode;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GenerationTask {

    private final String name;

    private final ArtifactType artifactType;

    private final BaseIRNode node;

    private final int order;

}