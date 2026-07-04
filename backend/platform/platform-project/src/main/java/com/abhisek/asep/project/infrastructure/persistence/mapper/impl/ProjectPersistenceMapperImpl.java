package com.abhisek.asep.project.infrastructure.persistence.mapper.impl;


import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.TechStack;
import com.abhisek.asep.project.infrastructure.persistence.entity.ProjectEntity;
import org.springframework.stereotype.Component;

@Component
public class ProjectPersistenceMapperImpl implements com.abhisek.asep.project.infrastructure.persistence.mapper.ProjectPersistenceMapper {

    @Override
    public ProjectEntity toEntity(Project project) {

        if (project == null) {
            return null;
        }

        return ProjectEntity.builder().id(project.getId()).name(project.getName()).description(project.getDescription()).ownerId(project.getOwnerId()).status(project.getStatus()).aiProvider(project.getAiProvider()).backend(project.getTechStack() != null ? project.getTechStack().getBackend() : null).frontend(project.getTechStack() != null ? project.getTechStack().getFrontend() : null).database(project.getTechStack() != null ? project.getTechStack().getDatabase() : null).messaging(project.getTechStack() != null ? project.getTechStack().getMessaging() : null).buildTool(project.getTechStack() != null ? project.getTechStack().getBuildTool() : null).cloud(project.getTechStack() != null ? project.getTechStack().getCloud() : null).container(project.getTechStack() != null ? project.getTechStack().getContainer() : null).createdAt(project.getCreatedAt()).updatedAt(project.getUpdatedAt()).build();
    }

    @Override
    public Project toDomain(ProjectEntity entity) {

        if (entity == null) {
            return null;
        }

        return Project.builder().id(entity.getId()).name(entity.getName()).description(entity.getDescription()).ownerId(entity.getOwnerId()).status(entity.getStatus()).aiProvider(entity.getAiProvider()).techStack(TechStack.builder().backend(entity.getBackend()).frontend(entity.getFrontend()).database(entity.getDatabase()).messaging(entity.getMessaging()).buildTool(entity.getBuildTool()).cloud(entity.getCloud()).container(entity.getContainer()).build()).createdAt(entity.getCreatedAt()).updatedAt(entity.getUpdatedAt()).build();
    }
}