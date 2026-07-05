package com.abhisek.asep.requirements.domain.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class RequirementVersion {

    private String id;

    private String requirementId;

    private Integer version;

    private String snapshot;

    private String createdBy;

    private Instant createdAt;

}