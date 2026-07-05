package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.service.RequirementCommandService;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRequirementUseCaseImpl
        implements DeleteRequirementUseCase {

    private final RequirementCommandService commandService;

    @Override
    public void execute(String requirementId) {

        commandService.delete(requirementId);

    }

}