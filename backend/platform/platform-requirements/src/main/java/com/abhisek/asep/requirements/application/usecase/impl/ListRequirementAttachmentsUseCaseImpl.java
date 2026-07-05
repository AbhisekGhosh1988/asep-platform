package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementAttachmentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementAttachmentApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementAttachmentService;
import com.abhisek.asep.requirements.application.usecase.ListRequirementAttachmentsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListRequirementAttachmentsUseCaseImpl implements ListRequirementAttachmentsUseCase {

    private final RequirementAttachmentService service;

    private final RequirementAttachmentApplicationMapper mapper;

    @Override
    public List<RequirementAttachmentResponse> execute(String requirementId) {

        return service.list(requirementId)

                .stream()

                .map(mapper::toResponse)

                .toList();

    }

}