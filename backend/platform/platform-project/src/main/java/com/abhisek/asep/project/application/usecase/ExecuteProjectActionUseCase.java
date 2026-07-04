package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.request.ProjectActionRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;

public interface ExecuteProjectActionUseCase {

    ProjectResponse execute(
            String projectId,
            ProjectActionRequest request);

}