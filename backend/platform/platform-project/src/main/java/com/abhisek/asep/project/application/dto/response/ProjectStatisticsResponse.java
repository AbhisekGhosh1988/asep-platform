package com.abhisek.asep.project.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectStatisticsResponse {

    private long members;

    private long requirements;

    private long architectures;

    private long generatedArtifacts;

    private long workflows;

}