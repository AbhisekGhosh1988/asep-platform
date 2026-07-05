package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementVersionResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementVersionApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementVersionService;
import com.abhisek.asep.requirements.application.usecase.GetRequirementVersionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetRequirementVersionUseCaseImpl implements GetRequirementVersionUseCase {

    private final RequirementVersionService versionService;
    private final RequirementVersionApplicationMapper mapper;

    @Override
    public RequirementVersionResponse execute(String requirementId, Integer version) {

        return mapper.toResponse(versionService.getVersion(requirementId, version));
    }
}