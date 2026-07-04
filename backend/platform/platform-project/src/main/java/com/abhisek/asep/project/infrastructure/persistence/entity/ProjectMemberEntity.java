package com.abhisek.asep.project.infrastructure.persistence.entity;

import com.abhisek.asep.project.domain.enums.ProjectRole;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "project_members", uniqueConstraints = {@UniqueConstraint(name = "uk_project_user", columnNames = {"project_id", "user_id"})})
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ProjectMemberEntity {

    @Id
    private String id;

    @Column(name = "project_id", nullable = false)
    private String projectId;

    @Column(name = "user_id", nullable = false)
    private String userId;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private ProjectRole role;

    @Column(name = "joined_at")
    private Instant joinedAt;

}