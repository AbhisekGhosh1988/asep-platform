package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;

public interface UpdateProjectUseCase {

    ProjectResponse execute(String id,
                            UpdateProjectRequest request);

}