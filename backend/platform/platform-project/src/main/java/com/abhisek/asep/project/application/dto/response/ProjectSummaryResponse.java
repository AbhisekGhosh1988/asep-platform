package com.abhisek.asep.project.application.dto.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ProjectSummaryResponse {

    private ProjectResponse project;

    private ProjectSettingsResponse settings;

    private ProjectStatisticsResponse statistics;

}