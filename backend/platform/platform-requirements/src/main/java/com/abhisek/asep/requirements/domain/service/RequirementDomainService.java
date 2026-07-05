package com.abhisek.asep.requirements.domain.service;

import com.abhisek.asep.core.domain.service.DomainService;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.requirements.domain.model.Requirement;

public interface RequirementDomainService
        extends DomainService {
    void validateCreate(Requirement requirement);

    void validateUpdate(Requirement requirement);

    void validateApprove(Requirement requirement);

    void validateReject(Requirement requirement);
}
