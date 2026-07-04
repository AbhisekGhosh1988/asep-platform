package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.service.ProjectSettingsService;
import com.abhisek.asep.project.application.usecase.GetProjectSettingsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProjectSettingsUseCaseImpl
        implements GetProjectSettingsUseCase {

    private final ProjectSettingsService service;

    @Override
    public ProjectSettingsResponse execute(String projectId) {

        return service.getSettings(projectId);

    }

}