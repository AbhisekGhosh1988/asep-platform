package com.abhisek.asep.generator.engine;

import com.abhisek.asep.generator.backend.BackendGenerationResult;
import com.abhisek.asep.generator.backend.BackendGenerator;
import com.abhisek.asep.generator.compiler.pipeline.CompilerPipeline;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.ir.builder.aggregate.AggregateIRBuilder;
import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.model.AggregateModel;
import com.abhisek.asep.generator.model.ProjectGenerationModel;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class DefaultGenerationEngine implements GenerationEngine {

    private final AggregateIRBuilder aggregateIRBuilder;

    private final CompilerPipeline compilerPipeline;

    private final BackendGenerator backendGenerator;

    @Override
    public BackendGenerationResult generate(ProjectGenerationModel project) {

        BackendGenerationResult.BackendGenerationResultBuilder result = BackendGenerationResult.builder();
        List<Path> generatedFiles = new ArrayList<>();
        for (AggregateModel aggregate : project.getDesign().getAggregates()) {

            AggregateIR aggregateIR = aggregateIRBuilder.build(aggregate);

            CompilerResult compilerResult = compilerPipeline.compile(aggregateIR);

            BackendGenerationResult backendResult = backendGenerator.generate(compilerResult);

            generatedFiles.addAll(backendResult.getGeneratedFiles());


        }

        return BackendGenerationResult.builder().generatedFiles(generatedFiles).build();

    }

}