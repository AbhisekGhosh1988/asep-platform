package com.abhisek.asep.requirements.domain.model;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAttachment {

    private String id;

    private String requirementId;

    private String fileName;

    private String originalFileName;

    private String contentType;

    private Long fileSize;

    private String storagePath;

    private String uploadedBy;

    private Instant uploadedAt;

}