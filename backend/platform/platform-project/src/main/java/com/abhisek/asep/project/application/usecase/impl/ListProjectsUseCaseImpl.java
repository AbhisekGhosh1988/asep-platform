package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.usecase.ListProjectsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListProjectsUseCaseImpl implements ListProjectsUseCase {

    private final ProjectService projectService;

    @Override
    public List<ProjectResponse> execute() {
        return projectService.findAll();
    }
}