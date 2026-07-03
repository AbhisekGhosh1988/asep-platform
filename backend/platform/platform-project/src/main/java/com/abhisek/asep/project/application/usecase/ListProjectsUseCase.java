package com.abhisek.asep.project.application.usecase;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;

import java.util.List;

public interface ListProjectsUseCase {

    List<ProjectResponse> execute();

}