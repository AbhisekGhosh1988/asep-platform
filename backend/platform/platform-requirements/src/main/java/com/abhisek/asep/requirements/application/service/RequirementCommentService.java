package com.abhisek.asep.requirements.application.service;

import com.abhisek.asep.requirements.domain.model.RequirementComment;

import java.util.List;

public interface RequirementCommentService {

    RequirementComment addComment(String requirementId, String comment, String commentedBy);

    List<RequirementComment> getComments(String requirementId);

    void deleteComment(String commentId);

}