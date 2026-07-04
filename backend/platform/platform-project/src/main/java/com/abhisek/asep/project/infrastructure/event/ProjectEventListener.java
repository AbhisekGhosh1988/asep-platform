package com.abhisek.asep.project.infrastructure.event;

import com.abhisek.asep.project.domain.event.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ProjectEventListener {

    @EventListener
    public void on(ProjectCreatedEvent event) {

        log.info("Project Created :: {} ({})", event.projectName(), event.projectId());

    }

    @EventListener
    public void on(ProjectUpdatedEvent event) {

        log.info("Project Updated :: {} ({})", event.projectName(), event.projectId());

    }

    @EventListener
    public void on(ProjectDeletedEvent event) {

        log.info("Project Deleted :: {}", event.projectId());

    }

    @EventListener
    public void on(ProjectActivatedEvent event) {

        log.info("Project Activated :: {}", event.projectId());

    }

    @EventListener
    public void on(ProjectArchivedEvent event) {

        log.info("Project Archived :: {}", event.projectId());

    }

    @EventListener
    public void on(ProjectMemberAddedEvent event) {

        log.info("Member Added :: {} -> {}", event.userId(), event.projectId());

    }

    @EventListener
    public void on(ProjectMemberRemovedEvent event) {

        log.info("Member Removed :: {} -> {}", event.userId(), event.projectId());

    }

}