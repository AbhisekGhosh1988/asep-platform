package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;

public interface GetProjectSettingsUseCase {

    ProjectSettingsResponse execute(String projectId);

}