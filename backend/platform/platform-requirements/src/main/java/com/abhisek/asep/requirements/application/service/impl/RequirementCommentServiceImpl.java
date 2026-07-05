package com.abhisek.asep.requirements.application.service.impl;

import com.abhisek.asep.core.support.RepositorySupport;
import com.abhisek.asep.requirements.application.service.RequirementCommentService;
import com.abhisek.asep.requirements.domain.exception.RequirementCommentNotFoundException;
import com.abhisek.asep.requirements.domain.model.RequirementComment;
import com.abhisek.asep.requirements.domain.repository.RequirementCommentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Transactional
public class RequirementCommentServiceImpl implements RequirementCommentService {

    private final RequirementCommentRepository repository;

    @Override
    public RequirementComment addComment(String requirementId, String comment, String commentedBy) {

        RequirementComment requirementComment = RequirementComment.builder().id(UUID.randomUUID().toString()).requirementId(Long.valueOf(requirementId)).comment(comment).commentedBy(commentedBy).commentedAt(Instant.now()).build();

        return repository.save(requirementComment);
    }

    @Override
    @Transactional(readOnly = true)
    public List<RequirementComment> getComments(String requirementId) {

        return repository.findByRequirementId(requirementId);
    }

    @Override
    public void deleteComment(String commentId) {

        RepositorySupport.require(

                repository.findById(commentId),

                () -> new RequirementCommentNotFoundException("Requirement comment not found"));

        repository.delete(commentId);
    }

}