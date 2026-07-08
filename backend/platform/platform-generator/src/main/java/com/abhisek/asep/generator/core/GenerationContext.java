package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.api.GenerationRequest;
import com.abhisek.asep.generator.api.GenerationResult;
import com.abhisek.asep.generator.session.GenerationSession;
import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GenerationContext {

    private GenerationRequest request;

    private GenerationSession session;

    @Builder.Default
    private GenerationResult result =
            GenerationResult.builder().build();

    private Instant startedAt;

    private Instant completedAt;

}