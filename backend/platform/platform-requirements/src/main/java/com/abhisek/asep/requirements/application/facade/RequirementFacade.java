package com.abhisek.asep.requirements.application.facade;

import com.abhisek.asep.core.application.facade.CrudFacade;
import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.ApproveRequirementRequest;
import com.abhisek.asep.requirements.application.dto.request.RejectRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;

import java.util.List;

public interface RequirementFacade extends CrudFacade<String, CreateRequirementRequest, UpdateRequirementRequest, RequirementResponse, RequirementSummaryResponse> {

    RequirementResponse create(String projectId, CreateRequirementRequest request);

    List<RequirementSummaryResponse> list(String projectId);

    RequirementResponse approve(String requirementId, ApproveRequirementRequest request);

    RequirementResponse reject(String requirementId, RejectRequirementRequest request);
}