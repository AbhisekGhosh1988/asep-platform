package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.usecase.GetProjectUseCase;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProjectUseCaseImpl implements GetProjectUseCase {

    private final ProjectService projectService;

    @Override
    public ProjectResponse execute(String id) {
        return projectService.getById(id);
    }
}