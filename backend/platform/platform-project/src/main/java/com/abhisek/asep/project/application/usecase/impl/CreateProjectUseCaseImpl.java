package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.usecase.CreateProjectUseCase;
import com.abhisek.asep.project.domain.exception.DuplicateProjectException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectStatus;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class CreateProjectUseCaseImpl implements CreateProjectUseCase {

    private final ProjectRepository projectRepository;
    private final ProjectApplicationMapper mapper;

    @Override
    public ProjectResponse execute(CreateProjectRequest request) {

        if (projectRepository.existsByName(request.getName())) {
            throw new DuplicateProjectException(
                    "Project already exists: " + request.getName());
        }

        Project project = Project.builder()
                .id(UUID.randomUUID().toString())
                .name(request.getName().trim())
                .description(request.getDescription())
                .ownerId(request.getOwnerId())
                .status(ProjectStatus.DRAFT)
                .aiProvider(request.getAiProvider())
                .createdAt(Instant.now())
                .updatedAt(Instant.now())
                .build();

        Project savedProject = projectRepository.save(project);

        return mapper.toResponse(savedProject);
    }
}