package com.abhisek.asep.requirements.infrastructure.persistence.entity;

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
    private Long id;

    private Long requirementId;

    private String comment;

    private String commentedBy;

    private Instant commentedAt;

}