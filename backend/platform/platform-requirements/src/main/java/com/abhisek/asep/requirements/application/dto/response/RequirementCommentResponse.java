package com.abhisek.asep.requirements.application.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class RequirementCommentResponse {

    private String id;

    private String requirementId;

    private String comment;

    private String commentedBy;

    private Instant commentedAt;

}