package com.abhisek.asep.requirements.infrastructure.persistence.entity;

import com.abhisek.asep.requirements.domain.enums.*;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "requirements")
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementEntity  {

    @Id
    private String id;

    @Column(nullable = false)
    private String projectId;

    @Column(nullable = false, length = 500)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Enumerated(EnumType.STRING)
    private RequirementType type;

    @Enumerated(EnumType.STRING)
    private RequirementStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    @Enumerated(EnumType.STRING)
    private Complexity complexity;

    @Enumerated(EnumType.STRING)
    private Source source;

    @Enumerated(EnumType.STRING)
    private Risk risk;

    @Column(nullable = false)
    private Integer version;

    private String parentRequirementId;


    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(
            name = "requirement_tags",
            joinColumns = @JoinColumn(name = "requirement_id"))
    @Column(name = "tag")
    @Builder.Default
    private Set<String> tags = new HashSet<>();

    @Column(name = "created_at", nullable = false, updatable = false)
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "updated_by")
    private String updatedBy;

    @Column(name = "approved_by")
    private String approvedBy;

}