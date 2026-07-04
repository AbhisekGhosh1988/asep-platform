package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.UpdateProjectSettingsRequest;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.service.ProjectSettingsService;
import com.abhisek.asep.project.application.usecase.UpdateProjectSettingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProjectSettingsUseCaseImpl implements UpdateProjectSettingsUseCase {

    private final ProjectSettingsService service;

    @Override
    public ProjectSettingsResponse execute(String projectId, UpdateProjectSettingsRequest request) {

        return service.updateSettings(projectId, request);

    }

}