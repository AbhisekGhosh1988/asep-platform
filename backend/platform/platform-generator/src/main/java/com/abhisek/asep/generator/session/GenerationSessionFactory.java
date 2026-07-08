package com.abhisek.asep.generator.session;

import com.abhisek.asep.generator.model.ProjectGenerationModel;

public interface GenerationSessionFactory {

    GenerationSession create(
            ProjectGenerationModel project);

}