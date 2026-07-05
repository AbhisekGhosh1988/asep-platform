package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementVersionApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementVersionService;
import com.abhisek.asep.requirements.application.usecase.GetRequirementVersionsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetRequirementVersionsUseCaseImpl
        implements GetRequirementVersionsUseCase {

    private final RequirementVersionService versionService;
    private final RequirementVersionApplicationMapper mapper;

    @Override
    public List<RequirementVersionResponse> execute(
            String requirementId) {

        return versionService.history(requirementId)
                .stream()
                .map(mapper::toResponse)
                .toList();
    }
}