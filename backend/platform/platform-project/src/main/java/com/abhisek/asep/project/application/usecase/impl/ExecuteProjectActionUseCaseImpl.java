package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.ProjectActionRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.service.ProjectLifecycleService;
import com.abhisek.asep.project.application.usecase.ExecuteProjectActionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ExecuteProjectActionUseCaseImpl implements ExecuteProjectActionUseCase {

    private final ProjectLifecycleService projectLifecycleService;

    @Override
    public ProjectResponse execute(String projectId, ProjectActionRequest request) {

        return projectLifecycleService.executeAction(projectId, request.getAction());

    }
}