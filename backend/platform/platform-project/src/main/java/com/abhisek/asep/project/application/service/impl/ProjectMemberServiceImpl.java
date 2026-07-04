package com.abhisek.asep.project.application.service.impl;

import com.abhisek.asep.common.event.DomainEventPublisher;
import com.abhisek.asep.project.application.dto.request.AddProjectMemberRequest;
import com.abhisek.asep.project.application.dto.response.ProjectMemberResponse;
import com.abhisek.asep.project.application.mapper.ProjectMemberApplicationMapper;
import com.abhisek.asep.project.application.service.ProjectMemberService;
import com.abhisek.asep.project.domain.event.ProjectMemberAddedEvent;
import com.abhisek.asep.project.domain.event.ProjectMemberRemovedEvent;
import com.abhisek.asep.project.domain.exception.ProjectNotFoundException;
import com.abhisek.asep.project.domain.model.Project;
import com.abhisek.asep.project.domain.model.ProjectMember;
import com.abhisek.asep.project.domain.repository.ProjectMemberRepository;
import com.abhisek.asep.project.domain.repository.ProjectRepository;
import com.abhisek.asep.project.domain.service.ProjectDomainService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProjectMemberServiceImpl implements ProjectMemberService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository memberRepository;
    private final ProjectMemberApplicationMapper mapper;
    private final ProjectDomainService domainService;
    private final DomainEventPublisher eventPublisher;

    @Override
    public ProjectMemberResponse addMember(String projectId, AddProjectMemberRequest request) {

        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + projectId));

        ProjectMember member = ProjectMember.builder().id(UUID.randomUUID().toString()).projectId(projectId).userId(request.getUserId()).role(request.getRole()).joinedAt(Instant.now()).build();

        domainService.validateAddMember(project, member);

        ProjectMember saved = memberRepository.save(member);

        eventPublisher.publish(new ProjectMemberAddedEvent(projectId, saved.getUserId(), Instant.now()));

        return mapper.toResponse(saved);

    }

    @Override
    public List<ProjectMemberResponse> getMembers(String projectId) {

        return memberRepository.findByProjectId(projectId).stream().map(mapper::toResponse).toList();

    }

    @Override
    public void removeMember(String projectId, String userId) {

        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectNotFoundException("Project not found: " + projectId));

        ProjectMember member = memberRepository.findByProjectIdAndUserId(projectId, userId).orElseThrow(() -> new IllegalArgumentException("Project member not found"));

        domainService.validateRemoveMember(project, member);

        memberRepository.delete(member);

        eventPublisher.publish(new ProjectMemberRemovedEvent(projectId, userId, Instant.now()));

    }

}