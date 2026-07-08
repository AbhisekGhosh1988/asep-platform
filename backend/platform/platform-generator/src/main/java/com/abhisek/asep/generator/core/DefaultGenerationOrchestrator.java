package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.api.GenerationRequest;
import com.abhisek.asep.generator.api.GenerationResult;
import com.abhisek.asep.generator.api.GenerationStatus;
import com.abhisek.asep.generator.session.GenerationSession;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class DefaultGenerationOrchestrator
        implements GenerationOrchestrator {

    private final GenerationPipeline pipeline;

    @Override
    public GenerationResult generate(
            GenerationRequest request) {

        GenerationContext context =
                GenerationContext.builder()
                        .request(request)
                        .session(GenerationSession.builder().build())
                        .startedAt(Instant.now())
                        .build();

        context.getResult().setStatus(GenerationStatus.RUNNING);

        pipeline.execute(context);

        context.setCompletedAt(Instant.now());

        context.getResult().setStatus(GenerationStatus.SUCCESS);

        return context.getResult();

    }

}