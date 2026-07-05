package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementAttachmentApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementAttachmentService;
import com.abhisek.asep.requirements.application.usecase.UploadRequirementAttachmentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class UploadRequirementAttachmentUseCaseImpl implements UploadRequirementAttachmentUseCase {

    private final RequirementAttachmentService service;

    private final RequirementAttachmentApplicationMapper mapper;

    @Override
    public RequirementAttachmentResponse execute(String requirementId, MultipartFile file, String uploadedBy) {
        return mapper.toResponse(service.upload(requirementId, file, uploadedBy));

    }

}