package com.abhisek.asep.project.application.mapper;

import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.domain.model.ProjectSettings;

public interface ProjectSettingsApplicationMapper {
    ProjectSettingsResponse toResponse(ProjectSettings settings);
}
