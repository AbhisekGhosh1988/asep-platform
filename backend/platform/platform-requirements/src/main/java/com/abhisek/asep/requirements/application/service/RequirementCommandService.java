package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.application.dto.request.*;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;

public interface RequirementCommandService {

    RequirementResponse create(
            String projectId,
            CreateRequirementRequest request);

    RequirementResponse update(
            String requirementId,
            UpdateRequirementRequest request);

    void delete(String requirementId);

    RequirementResponse approve(
            String requirementId,
            ApproveRequirementRequest request);

    RequirementResponse reject(
            String requirementId,
            RejectRequirementRequest request);

}