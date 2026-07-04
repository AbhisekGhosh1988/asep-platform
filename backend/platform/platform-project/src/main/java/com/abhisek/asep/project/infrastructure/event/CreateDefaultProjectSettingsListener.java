package com.abhisek.asep.project.infrastructure.event;

import com.abhisek.asep.project.domain.enums.*;
import com.abhisek.asep.project.domain.event.ProjectCreatedEvent;
import com.abhisek.asep.project.domain.model.ProjectSettings;
import com.abhisek.asep.project.domain.repository.ProjectSettingsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class CreateDefaultProjectSettingsListener {

    private final ProjectSettingsRepository repository;

    @EventListener
    public void on(ProjectCreatedEvent event) {

        if (repository.findByProjectId(event.projectId()).isPresent()) {
            return;
        }

        ProjectSettings settings = ProjectSettings.builder().id(UUID.randomUUID().toString())

                .projectId(event.projectId())

                .repositoryUrl(null)

                .defaultBranch("main")

                .backendFramework(BackendFramework.SPRING_BOOT)

                .frontendFramework(FrontendFramework.NONE)

                .database(DatabaseType.POSTGRESQL)

                .buildTool(BuildTool.MAVEN)

                .javaVersion(21)

                .containerPlatform(ContainerPlatform.NONE)

                .cloudProvider(CloudProvider.NONE)

                .aiProvider(AIProvider.OPENAI)

                .llmModel(LLMModel.GPT_5)

                .architectureStyle(ArchitectureStyle.HEXAGONAL)

                .createdAt(Instant.now())

                .updatedAt(Instant.now())

                .build();

        repository.save(settings);

    }

}