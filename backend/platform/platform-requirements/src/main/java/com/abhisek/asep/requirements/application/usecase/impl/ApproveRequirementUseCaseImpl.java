package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.request.ApproveRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.usecase.ApproveRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ApproveRequirementUseCaseImpl
        implements ApproveRequirementUseCase {

    private final RequirementCommandService commandService;

    @Override
    public RequirementResponse execute(
            String requirementId,
            ApproveRequirementRequest request) {

        return commandService.approve(
                requirementId,
                request);

    }

}