package com.abhisek.asep.requirements.application.dto.response;

import lombok.*;

import java.time.Instant;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RequirementVersionResponse {

    private String id;

    private Integer version;

    private String createdBy;

    private Instant createdAt;

}