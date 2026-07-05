package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.request.AddRequirementCommentRequest;
import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementCommentApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementCommentService;
import com.abhisek.asep.requirements.application.usecase.AddRequirementCommentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AddRequirementCommentUseCaseImpl implements AddRequirementCommentUseCase {

    private final RequirementCommentService service;
    private final RequirementCommentApplicationMapper mapper;

    @Override
    public RequirementCommentResponse execute(String requirementId, AddRequirementCommentRequest request) {

        return mapper.toResponse(

                service.addComment(

                        requirementId,

                        request.getComment(),

                        request.getCommentedBy()));

    }
}