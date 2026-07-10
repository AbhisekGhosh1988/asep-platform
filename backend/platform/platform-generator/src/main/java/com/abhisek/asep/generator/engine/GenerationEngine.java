package com.abhisek.asep.generator.engine;

import com.abhisek.asep.generator.backend.BackendGenerationResult;
import com.abhisek.asep.generator.model.ProjectGenerationModel;

/**
 * Entry point of the ASEP generation engine.
 */
public interface GenerationEngine {

    /**
     * Generates a complete project.
     *
     * @param project project generation model
     * @return backend generation result
     */
    BackendGenerationResult generate(
            ProjectGenerationModel project);

}