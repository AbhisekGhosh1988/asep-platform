package com.abhisek.asep.project.application.service.impl;

import com.abhisek.asep.project.application.dto.response.ProjectResponse;
import com.abhisek.asep.project.application.dto.response.ProjectSettingsResponse;
import com.abhisek.asep.project.application.dto.response.ProjectStatisticsResponse;
import com.abhisek.asep.project.application.dto.response.ProjectSummaryResponse;
import com.abhisek.asep.project.application.service.ProjectService;
import com.abhisek.asep.project.application.service.ProjectSettingsService;
import com.abhisek.asep.project.application.service.ProjectSummaryService;
import com.abhisek.asep.project.domain.repository.ProjectMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ProjectSummaryServiceImpl implements ProjectSummaryService {

    private final ProjectService projectService;

    private final ProjectSettingsService projectSettingsService;

    private final ProjectMemberRepository memberRepository;

    @Override
    public ProjectSummaryResponse getSummary(String projectId) {

        ProjectResponse project = projectService.getById(projectId);

        ProjectSettingsResponse settings = projectSettingsService.getSettings(projectId);

        long members = memberRepository.countByProjectId(projectId);

        ProjectStatisticsResponse statistics = ProjectStatisticsResponse.builder()

                .members(members)

                .requirements(0)

                .architectures(0)

                .generatedArtifacts(0)

                .workflows(0)

                .build();

        return ProjectSummaryResponse.builder()

                .project(project)

                .settings(settings)

                .statistics(statistics)

                .build();

    }

}