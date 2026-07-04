package com.abhisek.asep.project.application.service;

import com.abhisek.asep.project.application.dto.request.UpdateProjectSettingsRequest;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;

public interface ProjectSettingsService {

    ProjectSettingsResponse getSettings(String projectId);

    ProjectSettingsResponse updateSettings(String projectId, UpdateProjectSettingsRequest request);

}
