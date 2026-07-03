package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.usecase.UpdateProjectUseCase;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class UpdateProjectUseCaseImpl implements UpdateProjectUseCase {

    private final ProjectRepository repository;
    private final ProjectApplicationMapper mapper;

    @Override
    public ProjectResponse execute(String id,
                                   UpdateProjectRequest request) {

        Project project = repository.findById(id)
                .orElseThrow(() ->
                        new ProjectNotFoundException(
                                "Project not found: " + id));

        project.setName(request.getName());
        project.setDescription(request.getDescription());
        project.setAiProvider(request.getAiProvider());
        project.setUpdatedAt(Instant.now());

        return mapper.toResponse(repository.save(project));
    }
}