package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.usecase.CreateProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {

    private final ProjectService projectService;

    @Override
    public ProjectResponse execute(CreateProjectRequest request) {
        return projectService.create(request);
    }
}