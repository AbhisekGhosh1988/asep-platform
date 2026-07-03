package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;

public interface CreateProjectUseCase {
    ProjectResponse execute(CreateProjectRequest request);
}
