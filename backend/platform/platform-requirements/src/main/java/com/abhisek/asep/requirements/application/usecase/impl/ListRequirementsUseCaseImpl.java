package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementSummaryResponse;
import com.abhisek.asep.requirements.application.service.RequirementQueryService;
import com.abhisek.asep.requirements.application.usecase.ListRequirementsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListRequirementsUseCaseImpl
        implements ListRequirementsUseCase {

    private final RequirementQueryService queryService;

    @Override
    public List<RequirementSummaryResponse> execute(String projectId) {

        return queryService.list(projectId);

    }

}