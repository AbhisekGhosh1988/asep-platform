package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.response.ProjectSummaryResponse;

public interface GetProjectSummaryUseCase {

    ProjectSummaryResponse execute(String projectId);

}