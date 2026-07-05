package com.abhisek.asep.requirements.application.usecase.impl;

import com.abhisek.asep.requirements.application.service.RequirementCommentService;
import com.abhisek.asep.requirements.application.usecase.DeleteRequirementCommentUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteRequirementCommentUseCaseImpl implements DeleteRequirementCommentUseCase {

    private final RequirementCommentService service;

    @Override
    public void execute(String commentId) {

        service.deleteComment(commentId);

    }
}