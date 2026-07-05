package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionComparisonResponse;
import com.abhisek.asep.requirements.domain.model.Requirement;
import com.abhisek.asep.requirements.domain.model.RequirementVersion;

import java.util.List;

public interface RequirementVersionService {

    void createVersion(Requirement requirement);

    List<RequirementVersion> history(String requirementId);

    RequirementVersion getVersion(String requirementId, Integer version);

    Requirement restore(String requirementId, Integer version);

    RequirementVersionComparisonResponse compare(String requirementId, Integer sourceVersion, Integer targetVersion);


}