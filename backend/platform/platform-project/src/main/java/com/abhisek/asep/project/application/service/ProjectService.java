package com.abhisek.asep.project.application.service;

import com.abhisek.asep.project.application.dto.request.CreateProjectRequest;
import com.abhisek.asep.project.application.dto.request.UpdateProjectRequest;
import com.abhisek.asep.project.application.dto.response.ProjectResponse;

import java.util.List;

public interface ProjectService {

    ProjectResponse create(CreateProjectRequest request);

    ProjectResponse getById(String id);

    List<ProjectResponse> findAll();

    ProjectResponse update(String id, UpdateProjectRequest request);

    void delete(String id);

}