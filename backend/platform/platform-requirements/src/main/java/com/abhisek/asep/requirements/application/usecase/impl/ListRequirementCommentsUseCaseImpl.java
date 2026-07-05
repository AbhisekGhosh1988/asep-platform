package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementCommentApplicationMapper;
import com.abhisek.asep.requirements.application.service.RequirementCommentService;
import com.abhisek.asep.requirements.application.usecase.ListRequirementCommentsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListRequirementCommentsUseCaseImpl implements ListRequirementCommentsUseCase {

    private final RequirementCommentService service;
    private final RequirementCommentApplicationMapper mapper;

    @Override
    public List<RequirementCommentResponse> execute(String requirementId) {

        return service.getComments(requirementId).stream().map(mapper::toResponse).toList();
    }
}
