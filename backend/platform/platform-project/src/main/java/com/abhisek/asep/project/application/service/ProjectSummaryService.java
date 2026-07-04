package com.abhisek.asep.project.application.service;

import com.abhisek.asep.project.application.dto.response.ProjectSummaryResponse;

public interface ProjectSummaryService {

    ProjectSummaryResponse getSummary(String projectId);

}