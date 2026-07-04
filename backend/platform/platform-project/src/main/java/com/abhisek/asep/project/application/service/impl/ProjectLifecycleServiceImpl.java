package com.abhisek.asep.project.application.service.impl;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.mapper.ProjectApplicationMapper;
import com.abhisek.asep.project.application.service.ProjectLifecycleService;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectAction;
import com.abhisek.asep.project.domain.model.ProjectStatus;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import com.abhisek.asep.project.domain.service.ProjectDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ProjectLifecycleServiceImpl implements ProjectLifecycleService {

    private final ProjectRepository repository;
    private final ProjectDomainService domainService;
    private final ProjectApplicationMapper mapper;

    @Override
    public ProjectResponse executeAction(String projectId, ProjectAction action) {

        Project project = repository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + projectId));

        switch (action) {

            case ACTIVATE -> activate(project);

            case DEACTIVATE -> deactivate(project);

            case ARCHIVE -> archive(project);

            case RESTORE -> restore(project);

            default -> throw new ASEPException(ErrorCode.BAD_REQUEST, "Unsupported project action");

        }

        project.setUpdatedAt(Instant.now());

        repository.save(project);

        return mapper.toResponse(project);

    }

    private void activate(Project project) {

        domainService.validateActivate(project);

        project.setStatus(ProjectStatus.ACTIVE);

    }

    private void deactivate(Project project) {

        domainService.validateDeactivate(project);

        project.setStatus(ProjectStatus.INACTIVE);

    }

    private void archive(Project project) {

        domainService.validateArchive(project);

        project.setStatus(ProjectStatus.ARCHIVED);

    }

    private void restore(Project project) {

        domainService.validateRestore(project);

        project.setStatus(ProjectStatus.ACTIVE);

    }

}