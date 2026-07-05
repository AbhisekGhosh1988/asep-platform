package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.service.RequirementQueryService;
import com.abhisek.asep.requirements.application.usecase.GetRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRequirementUseCaseImpl
        implements GetRequirementUseCase {

    private final RequirementQueryService queryService;

    @Override
    public RequirementResponse execute(String requirementId) {

        return queryService.getById(requirementId);

    }

}