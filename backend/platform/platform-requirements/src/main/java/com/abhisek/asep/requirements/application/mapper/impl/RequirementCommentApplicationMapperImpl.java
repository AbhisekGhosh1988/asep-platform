package com.abhisek.asep.requirements.application.mapper.impl;

import com.abhisek.asep.requirements.application.dto.response.RequirementCommentResponse;
import com.abhisek.asep.requirements.application.mapper.RequirementCommentApplicationMapper;
import com.abhisek.asep.requirements.domain.model.RequirementComment;
import org.springframework.stereotype.Component;

@Component
public class RequirementCommentApplicationMapperImpl implements RequirementCommentApplicationMapper {
    @Override
    public RequirementCommentResponse toResponse(RequirementComment comment) {

        if (comment == null) {
            return null;
        }

        return RequirementCommentResponse.builder().id(comment.getId()).requirementId(String.valueOf(comment.getRequirementId())).comment(comment.getComment()).commentedBy(comment.getCommentedBy()).commentedAt(comment.getCommentedAt()).build();
    }
}

