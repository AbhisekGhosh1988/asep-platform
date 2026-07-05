package com.abhisek.asep.requirements.infrastructure.persistence.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "requirement_attachments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementAttachmentEntity {

    @Id
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