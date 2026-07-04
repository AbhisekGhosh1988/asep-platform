package com.abhisek.asep.project.application.usecase.impl;

import com.abhisek.asep.project.application.dto.response.ProjectSummaryResponse;
import com.abhisek.asep.project.application.service.ProjectSummaryService;
import com.abhisek.asep.project.application.usecase.GetProjectSummaryUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GetProjectSummaryUseCaseImpl implements GetProjectSummaryUseCase {

    private final ProjectSummaryService service;

    @Override
    public ProjectSummaryResponse execute(String projectId) {

        return service.getSummary(projectId);

    }

}