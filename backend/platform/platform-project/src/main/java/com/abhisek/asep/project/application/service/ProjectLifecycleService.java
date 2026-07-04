package com.abhisek.asep.project.application.service;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.domain.model.ProjectAction;

public interface ProjectLifecycleService {

    ProjectResponse executeAction(String projectId, ProjectAction action);

}