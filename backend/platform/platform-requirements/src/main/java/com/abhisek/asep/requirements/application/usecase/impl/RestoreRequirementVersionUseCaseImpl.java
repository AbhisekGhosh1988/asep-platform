package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementVersionService;
import com.abhisek.asep.requirements.application.usecase.RestoreRequirementVersionUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RestoreRequirementVersionUseCaseImpl implements RestoreRequirementVersionUseCase {

    private final RequirementVersionService versionService;
    private final RequirementApplicationMapper mapper;

    @Override
    public RequirementResponse execute(String requirementId, Integer version) {

        return mapper.toResponse(versionService.restore(requirementId, version));
    }
}