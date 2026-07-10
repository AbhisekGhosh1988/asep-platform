package com.abhisek.asep.generator.smoke;

import com.abhisek.asep.generator.backend.BackendGenerator;
import com.abhisek.asep.generator.compiler.pipeline.CompilerPipeline;
import com.abhisek.asep.generator.compiler.pipeline.CompilerResult;
import com.abhisek.asep.generator.ir.builder.aggregate.AggregateIRBuilder;
import com.abhisek.asep.generator.ir.model.AggregateIR;
import com.abhisek.asep.generator.model.AggregateModel;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class CompilerSmokeTest {

    @Autowired
    private AggregateIRBuilder aggregateIRBuilder;

    @Autowired
    private CompilerPipeline compilerPipeline;

    @Autowired
    private BackendGenerator backendGenerator;

    @Test
    void shouldCompileAggregate() {

        AggregateModel aggregate =
                TestAggregateFactory.projectAggregate();

        AggregateIR ir =
                aggregateIRBuilder.build(aggregate);

        CompilerResult result =
                compilerPipeline.compile(ir);

        backendGenerator.generate(result);

    }

}