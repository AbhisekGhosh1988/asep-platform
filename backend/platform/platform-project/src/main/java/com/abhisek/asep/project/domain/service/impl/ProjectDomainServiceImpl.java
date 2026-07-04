package com.abhisek.asep.project.domain.service.impl;

import com.abhisek.asep.common.enums.ErrorCode;
import com.abhisek.asep.common.exception.ASEPException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectStatus;
import com.abhisek.asep.project.domain.service.ProjectDomainService;
import org.springframework.stereotype.Service;

@Service
public class ProjectDomainServiceImpl implements ProjectDomainService {

    @Override
    public void validateCreate(Project project) {

        if (project.getName() == null || project.getName().isBlank()) {

            throw new ASEPException(ErrorCode.VALIDATION_FAILED, "Project name is required");

        }

    }

    @Override
    public void validateUpdate(Project project) {

        validateCreate(project);

    }

    @Override
    public void validateDelete(Project project) {

        if (project.getStatus() == ProjectStatus.ACTIVE) {

            throw new ASEPException(ErrorCode.BAD_REQUEST, "Active project cannot be deleted");

        }

    }

    @Override
    public void validateActivate(Project project) {

        if (project.getStatus() == ProjectStatus.ARCHIVED) {

            throw new ASEPException(ErrorCode.BAD_REQUEST, "Archived project cannot be activated");

        }

    }

    @Override
    public void validateDeactivate(Project project) {

        if (project.getStatus() == ProjectStatus.ARCHIVED) {

            throw new ASEPException(ErrorCode.BAD_REQUEST, "Archived project cannot be deactivated");

        }

    }

    @Override
    public void validateArchive(Project project) {

        if (project.getStatus() == ProjectStatus.ARCHIVED) {

            throw new ASEPException(ErrorCode.BAD_REQUEST, "Project already archived");

        }

    }

    @Override
    public void validateRestore(Project project) {

        if (project.getStatus() != ProjectStatus.ARCHIVED) {

            throw new ASEPException(ErrorCode.BAD_REQUEST, "Only archived projects can be restored");

        }

    }

}