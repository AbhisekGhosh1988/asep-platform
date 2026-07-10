//package com.abhisek.asep.generator.application;
//
//import com.abhisek.asep.generator.backend.BackendGenerator;
//import com.abhisek.asep.generator.compiler.pipeline.CompilerPipeline;
//import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
//import com.abhisek.asep.generator.ir.builder.aggregate.AggregateIRBuilder;
//import com.abhisek.asep.generator.ir.model.AggregateIR;
//import com.abhisek.asep.generator.model.AggregateModel;
//import com.abhisek.asep.generator.model.GenerationModel;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.stereotype.Service;
//
//@Slf4j
//@Service
//@RequiredArgsConstructor
//public class DefaultGenerationOrchestrator implements GenerationOrchestrator {
//
//    private final AggregateIRBuilder aggregateIRBuilder;
//
//    private final CompilerPipeline compilerPipeline;
//
//    private final BackendGenerator backendGenerator;
//
//    @Override
//    public void generate(GenerationModel generationModel) {
//
//        log.info("ASEP Generation Started");
//
//        for (AggregateModel aggregateModel : generationModel.getAggregates()) {
//
//            generateAggregate(aggregateModel);
//
//        }
//
//        log.info("ASEP Generation Finished");
//
//    }
//
//    private void generateAggregate(AggregateModel aggregateModel) {
//
//        log.info("Generating Aggregate : {}", aggregateModel.getName());
//
//        AggregateIR aggregateIR = aggregateIRBuilder.build(aggregateModel);
//
//        CompilerResult compilerResult = compilerPipeline.compile(aggregateIR);
//
//        backendGenerator.generate(compilerResult);
//
//    }
//
//}