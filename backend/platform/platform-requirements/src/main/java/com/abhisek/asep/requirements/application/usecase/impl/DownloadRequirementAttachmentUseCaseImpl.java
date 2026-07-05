package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.service.RequirementAttachmentService;
import com.abhisek.asep.requirements.application.usecase.DownloadRequirementAttachmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DownloadRequirementAttachmentUseCaseImpl
        implements DownloadRequirementAttachmentUseCase {

    private final RequirementAttachmentService service;

    @Override
    public Resource execute(String attachmentId) {

        return service.download(attachmentId);

    }

}