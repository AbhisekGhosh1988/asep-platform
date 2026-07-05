package com.abhisek.asep.project.domain.service;

import com.abhisek.asep.core.domain.service.DomainService;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectMember;

public interface ProjectDomainService extends DomainService {

    void validateCreate(Project project);

    void validateUpdate(Project project);

    void validateDelete(Project project);

    void validateActivate(Project project);

    void validateDeactivate(Project project);

    void validateArchive(Project project);

    void validateRestore(Project project);

    void validateAddMember(Project project, ProjectMember member);

    void validateRemoveMember(Project project, ProjectMember member);

}