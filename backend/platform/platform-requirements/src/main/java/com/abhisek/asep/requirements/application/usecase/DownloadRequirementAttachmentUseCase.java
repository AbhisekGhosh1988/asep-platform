package com.abhisek.asep.requirements.application.usecase;

import org.springframework.core.io.Resource;

public interface DownloadRequirementAttachmentUseCase {

    Resource execute(String attachmentId);

}