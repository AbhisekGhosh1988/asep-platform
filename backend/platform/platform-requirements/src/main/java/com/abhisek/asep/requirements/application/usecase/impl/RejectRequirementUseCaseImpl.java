package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.request.RejectRequirementRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.usecase.RejectRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RejectRequirementUseCaseImpl
        implements RejectRequirementUseCase {

    private final RequirementCommandService commandService;

    @Override
    public RequirementResponse execute(
            String requirementId,
            RejectRequirementRequest request) {

        return commandService.reject(
                requirementId,
                request);

    }

}