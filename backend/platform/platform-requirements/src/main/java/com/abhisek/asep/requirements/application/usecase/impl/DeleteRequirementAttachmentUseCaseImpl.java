package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.service.RequirementAttachmentService;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementAttachmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRequirementAttachmentUseCaseImpl
        implements DeleteRequirementAttachmentUseCase {

    private final RequirementAttachmentService service;

    @Override
    public void execute(String attachmentId) {

        service.delete(attachmentId);

    }

}