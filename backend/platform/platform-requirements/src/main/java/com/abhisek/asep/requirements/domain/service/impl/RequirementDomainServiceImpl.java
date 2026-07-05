package com.abhisek.asep.requirements.domain.service.impl;

import com.abhisek.asep.requirements.domain.enums.RequirementStatus;
import com.abhisek.asep.requirements.domain.exception.RequirementApprovalException;
import com.abhisek.asep.requirements.domain.exception.RequirementValidationException;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.service.RequirementDomainService;
import org.springframework.stereotype.Component;

@Component
public class RequirementDomainServiceImpl implements RequirementDomainService {
    @Override
    public void validateCreate(Requirement requirement) {
        if (requirement.getTitle() == null || requirement.getTitle().isBlank()) {

            throw new RequirementValidationException("Title is mandatory");

        }

    }

    @Override
    public void validateUpdate(Requirement requirement) {

        if (requirement.getTitle() == null || requirement.getTitle().isBlank()) {

            throw new RequirementValidationException("Requirement title is mandatory");

        }

    }
    @Override
    public void validateApprove(
            Requirement requirement) {

        if (requirement.getStatus()
                == RequirementStatus.APPROVED) {

            throw new RequirementApprovalException(
                    "Requirement already approved");

        }

    }
    @Override
    public void validateReject(
            Requirement requirement) {

        if (requirement.getStatus()
                == RequirementStatus.REJECTED) {

            throw new RequirementValidationException(
                    "Requirement already rejected");

        }

    }
}
