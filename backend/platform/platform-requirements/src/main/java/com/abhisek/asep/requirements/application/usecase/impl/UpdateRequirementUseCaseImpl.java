package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.request.UpdateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.usecase.UpdateRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UpdateRequirementUseCaseImpl
        implements UpdateRequirementUseCase {

    private final RequirementCommandService commandService;

    @Override
    public RequirementResponse execute(
            String requirementId,
            UpdateRequirementRequest request) {

        return commandService.update(
                requirementId,
                request);

    }

}