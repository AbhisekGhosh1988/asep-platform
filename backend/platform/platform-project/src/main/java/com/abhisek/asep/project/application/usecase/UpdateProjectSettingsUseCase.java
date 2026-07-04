package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.request.UpdateProjectSettingsRequest;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;

public interface UpdateProjectSettingsUseCase {

    ProjectSettingsResponse execute(
            String projectId,
            UpdateProjectSettingsRequest request);

}