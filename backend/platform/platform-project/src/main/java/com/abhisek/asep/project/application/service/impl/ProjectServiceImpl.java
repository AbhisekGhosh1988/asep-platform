package com.abhisek.asep.project.application.service.impl;

import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.domain.exception.DuplicateProjectException;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectStatus;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import com.abhisek.asep.project.domain.service.ProjectDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository repository;
    private final ProjectApplicationMapper mapper;
    private final ProjectDomainService domainService;

    @Override
    public ProjectResponse create(CreateProjectRequest request) {

        if (repository.existsByName(request.getName())) {
            throw new DuplicateProjectException("Project already exists: " + request.getName());
        }

        Project project = Project.builder().id(UUID.randomUUID().toString()).name(request.getName().trim()).description(request.getDescription()).ownerId(request.getOwnerId()).status(ProjectStatus.DRAFT).aiProvider(request.getAiProvider()).createdAt(Instant.now()).updatedAt(Instant.now()).build();
        domainService.validateCreate(project);
        return mapper.toResponse(repository.save(project));
    }

    @Override
    public ProjectResponse getById(String id) {

        return mapper.toResponse(repository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + id)));
    }

    @Override
    public List<ProjectResponse> findAll() {

        return repository.findAll().stream().map(mapper::toResponse).toList();
    }

    @Override
    public ProjectResponse update(String id, UpdateProjectRequest request) {

        Project project = repository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + id));

        project.setName(request.getName().trim());
        project.setDescription(request.getDescription());
        project.setAiProvider(request.getAiProvider());
        project.setUpdatedAt(Instant.now());

        domainService.validateUpdate(project);
        return mapper.toResponse(repository.save(project));
    }

    @Override
    public void delete(String id) {
        Project project = repository.existsById(id) ? repository.findById(id).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + id)) : null;
        domainService.validateDelete(project);
        repository.deleteById(id);
    }
}