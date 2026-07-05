package com.abhisek.asep.requirements.application.dto.response;

import lombok.Builder;
import lombok.Getter;

import java.time.Instant;

@Getter
@Builder
public class RequirementAttachmentResponse {

    private String id;

    private String requirementId;

    private String fileName;

    private String originalFileName;

    private String contentType;

    private Long fileSize;

    private String uploadedBy;

    private Instant uploadedAt;

}