package com.abhisek.asep.generator.core;

import com.abhisek.asep.generator.api.GenerationRequest;
import com.abhisek.asep.generator.api.GenerationResult;

public interface GenerationOrchestrator {

    GenerationResult generate(
            GenerationRequest request);

}