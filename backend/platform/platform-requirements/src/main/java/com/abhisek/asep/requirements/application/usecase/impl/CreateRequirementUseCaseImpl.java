package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.request.CreateRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.usecase.CreateRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateRequirementUseCaseImpl
        implements CreateRequirementUseCase {

    private final RequirementCommandService commandService;

    @Override
    public RequirementResponse execute(
            String projectId,
            CreateRequirementRequest request) {

        return commandService.create(projectId, request);

    }

}