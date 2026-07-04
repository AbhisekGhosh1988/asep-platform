package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.usecase.UpdateProjectUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {

    private final ProjectService projectService;

    @Override
    public ProjectResponse execute(String id,
                                   UpdateProjectRequest request) {

        return projectService.update(id, request);
    }
}