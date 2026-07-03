package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;

public interface GetProjectUseCase {

    ProjectResponse execute(String id);

}