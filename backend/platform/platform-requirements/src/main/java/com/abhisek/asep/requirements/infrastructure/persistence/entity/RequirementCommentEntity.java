package com.abhisek.asep.requirements.infrastructure.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "requirement_comments")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementCommentEntity {

    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "requirement_id", nullable = false)
    private String requirementId;

    @Column(name = "comment", columnDefinition = "TEXT")
    private String comment;

    @Column(name = "created_by")
    private String commentedBy;

    @Column(name = "created_at")
    private Instant commentedAt;

}