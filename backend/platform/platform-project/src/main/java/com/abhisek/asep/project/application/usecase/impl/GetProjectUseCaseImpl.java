package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.usecase.GetProjectUseCase;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProjectUseCaseImpl implements GetProjectUseCase {

    private final ProjectRepository repository;
    private final ProjectApplicationMapper mapper;

    @Override
    public ProjectResponse execute(String id) {

        return mapper.toResponse(
                repository.findById(id)
                        .orElseThrow(() ->
                                new ProjectNotFoundException(
                                        "Project not found: " + id))
        );
    }
}